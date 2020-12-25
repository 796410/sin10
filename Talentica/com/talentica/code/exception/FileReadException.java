package com.talentica.code.exception;

/**
 * Exception class for File Read
 * 
 * @author Sayantan Ganguly
 *
 */
public class FileReadException extends Exception {
	
	public FileReadException(String message){
		super(message);
	}

	public FileReadException(String message, Throwable throwable){
		super(message,throwable);
	}
}
