package com.zeta.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.zeta.error.ApiError;
import com.zeta.exception.TidNotFoundException;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

	@ExceptionHandler(value = TidNotFoundException.class)
	public ResponseEntity<ApiError> handleNoTidFoundException(){
		
		ApiError error=new ApiError(400, "TID is not valid", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}
}
