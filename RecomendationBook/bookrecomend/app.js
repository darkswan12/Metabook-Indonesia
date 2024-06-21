const express = require('express');
const axios = require('axios');
const tf = require('@tensorflow/tfjs-node');
const app = express();
const PORT = process.env.PORT || 3000;
const GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";

app.use(express.json());

// Function to fetch books from Google Books API
const model = tf.loadGraphModel('https://storage.googleapis.com/mlrecomend/modelmetabook.json')
const fetchBooks = async (query, categories) => {
  try {
    const params = {
      q: `${query} ${categories.map(category => `subject:${category}`).join(' ')}`,
      maxResults: 5
      
    };    
    const response = await axios.get(GOOGLE_BOOKS_API_URL, { params });
    return response.data.items || [];
  } catch (error) {
    console.error("Error fetching books:", error);
    return [];
  }
};

// Function to parse book information
const parseBookInfo = (book) => {
  const volumeInfo = book.volumeInfo || {};
  server.app.model = model;  
  return {
    title: volumeInfo.title,
    authors: volumeInfo.authors,
    publisher: volumeInfo.publisher,
    publishedDate: volumeInfo.publishedDate,
    description: volumeInfo.description,
    industryIdentifiers: volumeInfo.industryIdentifiers,
    pageCount: volumeInfo.pageCount,
    categories: volumeInfo.categories,
    averageRating: volumeInfo.averageRating,
    ratingsCount: volumeInfo.ratingsCount,
    maturityRating: volumeInfo.maturityRating,
    imageLinks: volumeInfo.imageLinks,
    language: volumeInfo.language,    
  };
  
};

// Endpoint to get book recommendations
app.post('/recommend', async (req, res) => {
  const { title, categories } = req.body;

  if (!title || !categories) {
    return res.status(400).json({ error: 'Title and categories are required' });
  }

  const books = await fetchBooks(title, categories);
  const recommendations = books.map(parseBookInfo);

  res.json(recommendations);
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
