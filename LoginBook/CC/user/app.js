const express = require('express');
const axios = require('axios');
const tf = require('@tensorflow/tfjs-node');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware untuk parsing body JSON
app.use(express.json());

// Fungsi untuk mendapatkan rekomendasi buku berdasarkan kategori
async function getRecommendations(categories) {
    const books = [];
    for (let category of categories) {            
        const response = await axios.get(`https://www.googleapis.com/books/v1/volumes?q=${category}&key=AIzaSyDdWzNgGVN-QhwCcvCPvdqSalsYiBBZKHo`);
        const bookData = response.data.items.map(item => {
            const volumeInfo = item.volumeInfo;
            const model=tf.loadGraphModel('https://storage.googleapis.com/loginml/logiin.json')
            return {
                id: item.id,
                etag: item.etag,
                title: volumeInfo.title,
                description: volumeInfo.description,
                categories: volumeInfo.categories,
                selfLink: item.selfLink,
                imageLinks: volumeInfo.imageLinks
            };
        });
        books.push(...bookData);
        server.app.model = model;
    }
    return books;
}

// API endpoint untuk mendapatkan rekomendasi berdasarkan kategori
app.post('/logrecommend', async (req, res) => {
    try {
        const { categories } = req.body;
        const recommendations = await getRecommendations(categories);
        res.json(recommendations);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Menjalankan server
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});