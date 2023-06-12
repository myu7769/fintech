package com.zerobase.api.product

enum class Organization(val organization: String) {
    ORGANIZATION_ONE("00001"),
    ORGANIZATION_TWO("00002"),
    NONE("00003");

    companion object {
        fun getByString(organization: String): String {
            return when (organization) {
                "ORGANIZATION_ONE" -> "00001"
                "ORGANIZATION_TWO" -> "00002"
                "NONE" -> "00003"
                else -> throw IllegalArgumentException("Invalid organization: $organization")
            }
        }
    }
}
