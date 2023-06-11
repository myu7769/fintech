package com.zerobase.api.loan.review

import org.springframework.stereotype.Service

@Service
interface LoanReviewService {


    fun loanReviewMain(userKey : String) : LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey : String) : LoanReviewDto.LoanReview
}