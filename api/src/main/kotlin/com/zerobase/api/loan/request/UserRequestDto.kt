package com.zerobase.api.loan.request

class UserRequestDto {
    data class UserRequestInputDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String // 암호화 필요한 필드
    ){

        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )

    }
    data class UserDataDto(
        val userName: String,
        var userRegistrationNumber: String, // 암호화 필요한 필드
    )

    data class UserRequestResponseDto(
        val data: UserDataDto,
        val responseCode : String,
        val responseMessage : String
    )

    data class InformationDto(
        val userKey: String
    )

    data class InformationResponseDto(
        val data: InformationDto,
        val responseCode : String,
        val responseMessage : String
    )

}