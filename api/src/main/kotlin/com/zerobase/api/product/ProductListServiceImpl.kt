package com.zerobase.api.product


import com.zerobase.api.loan.request.ResponseStatus
import com.zerobase.api.loan.request.UserInfoDto
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.repository.ProductListRepository
import org.springframework.stereotype.Service

@Service
class ProductListServiceImpl(
    private val productInfoRepository: ProductInfoRepository

) : ProductListService {

    override fun getProductInfo(organization: String): ProductDto.ProductResponseDto {
        var productInfo =  productInfoRepository.findByorganizationCode(organization)

        return ProductDto.ProductResponseDto(
            ProductDto.ProductDataDto(productInfo!!.organizationCode, productInfo.productName, productInfo.productMaximumInterest,
                productInfo.productMinimumInterest, productInfo.productCode),
            ResponseStatus.SUCCESS.code, ResponseStatus.SUCCESS.message
        )
    }

    override fun saveProductInfo(productDto: ProductDto) : ProductDto.SuccessDto {


        val productInfo = productInfoRepository.save(productDto.toEntity())
            ?: throw Exception("Failed to save product info")

        return ProductDto.SuccessDto(ResponseStatus.SUCCESS.code, ResponseStatus.SUCCESS.message);
    }

}
