package com.toycommerce.member.shared.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 전역에서 slf4j 로거로 접근하기 위한 인라인 확장 함수 정의
 */
inline fun <reified T> T.log(): Logger {
    return LoggerFactory.getLogger(T::class.java)
}