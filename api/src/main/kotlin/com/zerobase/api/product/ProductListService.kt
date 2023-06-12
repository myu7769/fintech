package com.zerobase.api.product

import com.zerobase.api.loan.request.UserInfoDto
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.domain.ProductList
import com.zerobase.domain.domain.UserInfo


interface ProductListService {
    fun getProductInfo(organization: String): ProductDto.ProductResponseDto?

    fun saveProductInfo(
        productDto: ProductDto
    ) : ProductDto.SuccessDto
}
