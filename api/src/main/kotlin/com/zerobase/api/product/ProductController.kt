package com.zerobase.api.product

import com.zerobase.api.loan.request.LoanRequestDto
import com.zerobase.api.loan.request.UserRequestDto
import com.zerobase.domain.domain.ProductList
import com.zerobase.domain.repository.ProductListRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1")
class ProductController(

    private val productListServiceImpl: ProductListServiceImpl
) {

    @GetMapping("product/{organizationCode}")
    fun getReviewData(@PathVariable organizationCode : String) : ResponseEntity<ProductDto.ProductResponseDto>? {

         return ResponseEntity.ok(
            productListServiceImpl.getProductInfo(organizationCode)
        )
    }

    @PostMapping("product/Information")
    fun requestProduct(@RequestBody productDto: ProductDto
    ) : ResponseEntity<ProductDto.SuccessDto> {

        return ResponseEntity.ok(
            productListServiceImpl.saveProductInfo(productDto)
        )
    }

}