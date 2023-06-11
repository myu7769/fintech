package com.zerobase.api.loan.request

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/user")
class LoanRequestController(
    private val loanRequestServiceImpl: LoanRequestServiceImpl
) {

    @PostMapping("/information")
    fun loanRequest(
        @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): ResponseEntity<UserRequestDto.InformationResponseDto> {

        return ResponseEntity.ok(
            loanRequestServiceImpl.loanRequestMain(loanRequestInputDto)
        )
    }

    @GetMapping("private-info/{userKey}")
    fun getReviewData(@PathVariable userKey : String) : ResponseEntity<UserRequestDto.UserRequestResponseDto> {

        return ResponseEntity.ok(
            loanRequestServiceImpl.getUserInfo(userKey)
        )
    }
}