package com.toycommerce.member.was.adapter.`in`.http

/**
 * http Member-Resource 요청시 사용되는 public interface Response 정의
 *
 * swagger를 통한 model doc 문서화
 */

data class SellerRegistrationResponse(
    val id: Long,
    val email: String,
)

data class BuyerRegistrationResponse(
    val id: Long,
    val email: String,
)

data class AdminRegistrationResponse(
    val id: Long,
    val email: String,
)