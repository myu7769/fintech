package com.zerobase.domain.domain

import java.math.BigInteger
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PRODUCT_LIST")
class ProductList(
    @Column(name = "org_cd")
    val originalCd: String,

    @Column(name = "prod_cd")
    val productCd: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}