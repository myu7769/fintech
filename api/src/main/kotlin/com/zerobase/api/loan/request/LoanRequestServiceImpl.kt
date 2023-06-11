package com.zerobase.api.loan.request


import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import com.zerobase.kafka.enum.KafkaTopic
import com.zerobase.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(

    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent,
    private val loanRequestSender: LoanRequestSender


) : LoanRequestService {

    override fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInputDto): UserRequestDto.InformationResponseDto {

        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)

        loanRequestReview(userInfoDto)

        return UserRequestDto.InformationResponseDto(
            UserRequestDto.InformationDto(userKey),
            ResponseStatus.SUCCESS.code, ResponseStatus.SUCCESS.message)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfoDto.toLoanRequestKafkaDto()
        )
    }

    override fun getUserInfo(userKey: String): UserRequestDto.UserRequestResponseDto {

        val userInfoDto = userInfoRepository.findByUserKey(userKey)


        return UserRequestDto.UserRequestResponseDto(
            UserRequestDto.UserDataDto(userInfoDto.userKey, userInfoDto.userRegistrationNumber),
            ResponseStatus.SUCCESS.code, ResponseStatus.SUCCESS.message)

    }
}