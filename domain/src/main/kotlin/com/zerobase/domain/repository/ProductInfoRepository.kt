package com.zerobase.domain.repository

import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.domain.ProductList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface ProductInfoRepository : JpaRepository<ProductInfo, Long> {
    fun findByorganizationCode(organization: String) : ProductInfo?


}