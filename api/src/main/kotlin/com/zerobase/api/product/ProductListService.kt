package com.zerobase.api.product


interface ProductListService {
    fun getProductInfo(organization: String): ProductDto.ProductResponseDto?
}
