package com.zerobase.api.product


import com.zerobase.api.loan.request.ResponseStatus
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.repository.ProductListRepository
import org.springframework.stereotype.Service

@Service
class ProductListServiceImpl(
    private val productInfoRepository: ProductInfoRepository

) : ProductListService {

    override fun getProductInfo(organization: String): ProductDto.ProductResponseDto? {
        var productInfo =  productInfoRepository.findByoriginalCd(organization)

        return ProductDto.ProductResponseDto(
            ProductDto.ProductDataDto(productInfo!!.originalCd, productInfo.productCd, productInfo.productMax,
                productInfo.productMin, productInfo.productCd),
            ResponseStatus.SUCCESS.code, ResponseStatus.SUCCESS.message
        )
    }
}
