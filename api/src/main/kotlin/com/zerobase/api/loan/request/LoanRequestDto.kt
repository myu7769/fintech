package com.zerobase.api.loan.request


class LoanRequestDto {
    data class LoanRequestInputDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String, // 암호화 필요한 필드
    ){

        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )

    }

    data class LoanRequestResponseDto(
        val userKey: String


    )
}