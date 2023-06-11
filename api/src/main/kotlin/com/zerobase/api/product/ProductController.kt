package com.zerobase.api.product

import com.zerobase.api.loan.request.UserRequestDto
import com.zerobase.domain.domain.ProductList
import com.zerobase.domain.repository.ProductListRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/v1")
class ProductController(

    private val productListServiceImpl: ProductListServiceImpl
) {

    @GetMapping("product/{organizationCode}")
    fun getReviewData(@PathVariable organizationCode : Organization) : ResponseEntity<ProductDto.ProductResponseDto> {


        return ResponseEntity.ok(
            productListServiceImpl.getProductInfo(organizationCode.toString())
        )
    }

}