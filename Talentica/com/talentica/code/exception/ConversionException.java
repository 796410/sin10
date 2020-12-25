package com.talentica.code.exception;

/**
 * Exception class for 
 * conversion
 * 
 * @author Sayantan Ganguly
 *
 */
public class ConversionException extends RuntimeException {

	public ConversionException(String message){
		super(message);
	}

	public ConversionException(String message, Throwable throwable){
		super(message,throwable);
	}

}
