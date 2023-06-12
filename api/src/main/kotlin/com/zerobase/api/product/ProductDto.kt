package com.zerobase.api.product

import com.zerobase.api.loan.request.UserRequestDto
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.domain.UserInfo


class ProductDto(

    private val originalCd: String,
    private val productCd: String,
    private val productNumber: String,
    private val productMin: Double,
    private val productMax: Double

) {
    fun toEntity(): ProductInfo =

        ProductInfo(
            originalCd, productCd, productNumber, productMin, productMax
        )

    data class ProductResponseDto(
        val data: ProductDataDto,
        val responseCode : String,
        val responseMessage : String
    )

    data class ProductDataDto(
        val originalCode : String,
        val productCode : String,
        val productMaximumInterest : Double,
        val productMinimumInterest : Double,
        val productNumber : String
    )

    data class SuccessDto(
            val responseCode : String,
            val responseMessage : String
    )

}
