package com.toycommerce.member.shared.exception

import com.toycommerce.member.shared.log.log
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.naming.AuthenticationException

/**
 * 예외 처리 AOP 핸들러
 *
 * @return ErrorResponse
 */
@RestControllerAdvice
class RestControllerExceptionHandler {

    /**
     * 비즈니스 예외에 대한 일괄 핸들링
     */
    @ExceptionHandler(BusinessException::class)
    protected fun handle(exception: BusinessException): ResponseEntity<Any?> {
        if (exception.isNecessaryToLog) {
            log().error(exception.message, exception)
        }
        return ResponseEntity<Any?>(ErrorResponse(exception.javaClass.simpleName, exception.message), HttpHeaders(), exception.httpStatus)
    }

    /**
     * 인지하지 못한 예외 처리, 서버사이드에서 처리 필요
     */
    @ExceptionHandler(Throwable::class)
    protected fun handle(throwable: Throwable): ResponseEntity<ErrorResponse> {
        log().error(throwable.message, throwable)
        return ResponseEntity<ErrorResponse>(ErrorResponse(throwable.javaClass.simpleName, throwable.message), HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    /**
     * 400 validate 예외처리
     */
    @ExceptionHandler(
        IllegalArgumentException::class,
        MethodArgumentNotValidException::class,
        MissingServletRequestParameterException::class,
        MethodArgumentNotValidException::class,
        HttpRequestMethodNotSupportedException::class,
        MissingRequestHeaderException::class,
        HttpMessageNotReadableException::class,
        MethodArgumentTypeMismatchException::class
    )
    protected fun handle(exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity<ErrorResponse>(ErrorResponse(exception.javaClass.simpleName, exception.message), HttpHeaders(), HttpStatus.BAD_REQUEST)
    }


    /**
     * 인증 필요 401 에러
     */
    @ExceptionHandler(AuthenticationException::class)
    protected fun handleAuthenticationException(exception: AuthenticationException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(exception.javaClass.simpleName, "Need Authentication.")
        return ResponseEntity<ErrorResponse>(errorResponse, HttpHeaders(), HttpStatus.UNAUTHORIZED)
    }

    /**
     * 인가 필요 403 에러
     */
    @ExceptionHandler(AccessDeniedException::class)
    protected fun handleAccessDeniedException(exception: AccessDeniedException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(exception.javaClass.simpleName, "Access Denied.")
        return ResponseEntity<ErrorResponse>(errorResponse, HttpHeaders(), HttpStatus.FORBIDDEN)
    }
}