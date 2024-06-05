package com.example.metabook.data.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("totalItems")
	val totalItems: Int? = null,

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class Pdf(

	@field:SerializedName("isAvailable")
	val isAvailable: Boolean? = null,

	@field:SerializedName("acsTokenLink")
	val acsTokenLink: String? = null
)

data class AccessInfo(

	@field:SerializedName("accessViewStatus")
	val accessViewStatus: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("viewability")
	val viewability: String? = null,

	@field:SerializedName("pdf")
	val pdf: Pdf? = null,

	@field:SerializedName("webReaderLink")
	val webReaderLink: String? = null,

	@field:SerializedName("epub")
	val epub: Epub? = null,

	@field:SerializedName("publicDomain")
	val publicDomain: Boolean? = null,

	@field:SerializedName("quoteSharingAllowed")
	val quoteSharingAllowed: Boolean? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null,

	@field:SerializedName("textToSpeechPermission")
	val textToSpeechPermission: String? = null
)

data class Epub(

	@field:SerializedName("isAvailable")
	val isAvailable: Boolean? = null,

	@field:SerializedName("acsTokenLink")
	val acsTokenLink: String? = null
)

data class SaleInfo(

	@field:SerializedName("offers")
	val offers: List<OffersItem?>? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("isEbook")
	val isEbook: Boolean? = null,

	@field:SerializedName("saleability")
	val saleability: String? = null,

	@field:SerializedName("buyLink")
	val buyLink: String? = null,

	@field:SerializedName("retailPrice")
	val retailPrice: RetailPrice? = null,

	@field:SerializedName("listPrice")
	val listPrice: ListPrice? = null
)

data class ReadingModes(

	@field:SerializedName("image")
	val image: Boolean? = null,

	@field:SerializedName("text")
	val text: Boolean? = null
)

data class PanelizationSummary(

	@field:SerializedName("containsImageBubbles")
	val containsImageBubbles: Boolean? = null,

	@field:SerializedName("containsEpubBubbles")
	val containsEpubBubbles: Boolean? = null
)

data class ItemsItem(

	@field:SerializedName("saleInfo")
	val saleInfo: SaleInfo? = null,

	@field:SerializedName("searchInfo")
	val searchInfo: SearchInfo? = null,

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("volumeInfo")
	val volumeInfo: VolumeInfo? = null,

	@field:SerializedName("etag")
	val etag: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("accessInfo")
	val accessInfo: AccessInfo? = null,

	@field:SerializedName("selfLink")
	val selfLink: String? = null
)

data class ImageLinks(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("smallThumbnail")
	val smallThumbnail: String? = null
)

data class RetailPrice(

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("currencyCode")
	val currencyCode: String? = null,

	@field:SerializedName("amountInMicros")
	val amountInMicros: Long? = null
)

data class OffersItem(

	@field:SerializedName("finskyOfferType")
	val finskyOfferType: Int? = null,

	@field:SerializedName("retailPrice")
	val retailPrice: RetailPrice? = null,

	@field:SerializedName("listPrice")
	val listPrice: ListPrice? = null
)

data class ListPrice(

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("currencyCode")
	val currencyCode: String? = null,

	@field:SerializedName("amountInMicros")
	val amountInMicros: Long? = null
)

data class SearchInfo(

	@field:SerializedName("textSnippet")
	val textSnippet: String? = null
)

data class IndustryIdentifiersItem(

	@field:SerializedName("identifier")
	val identifier: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class VolumeInfo(

	@field:SerializedName("industryIdentifiers")
	val industryIdentifiers: List<IndustryIdentifiersItem?>? = null,

	@field:SerializedName("pageCount")
	val pageCount: Int? = null,

	@field:SerializedName("printType")
	val printType: String? = null,

	@field:SerializedName("readingModes")
	val readingModes: ReadingModes? = null,

	@field:SerializedName("previewLink")
	val previewLink: String? = null,

	@field:SerializedName("canonicalVolumeLink")
	val canonicalVolumeLink: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("imageLinks")
	val imageLinks: ImageLinks? = null,

	@field:SerializedName("averageRating")
	val averageRating: Int? = null,

	@field:SerializedName("panelizationSummary")
	val panelizationSummary: PanelizationSummary? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("ratingsCount")
	val ratingsCount: Int? = null,

	@field:SerializedName("publishedDate")
	val publishedDate: String? = null,

	@field:SerializedName("categories")
	val categories: List<String?>? = null,

	@field:SerializedName("maturityRating")
	val maturityRating: String? = null,

	@field:SerializedName("allowAnonLogging")
	val allowAnonLogging: Boolean? = null,

	@field:SerializedName("contentVersion")
	val contentVersion: String? = null,

	@field:SerializedName("authors")
	val authors: List<String?>? = null,

	@field:SerializedName("infoLink")
	val infoLink: String? = null,

	@field:SerializedName("subtitle")
	val subtitle: String? = null
)
