package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo

interface LoanRequestService {

    fun loanRequestMain(loanRequestDto: LoanRequestDto.LoanRequestInputDto
    ): UserRequestDto.InformationResponseDto

    fun saveUserInfo(
        userInfoDto: UserInfoDto
    ) : UserInfo

    fun loanRequestReview(userInfoDto: UserInfoDto)

    fun getUserInfo(userKey: String): UserRequestDto.UserRequestResponseDto?

}