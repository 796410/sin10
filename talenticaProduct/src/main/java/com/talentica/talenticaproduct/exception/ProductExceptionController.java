package com.talentica.talenticaproduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = Exception.class)
	   public ResponseEntity<Object> exception(Exception exception) {
		  exception.printStackTrace();
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }

}
