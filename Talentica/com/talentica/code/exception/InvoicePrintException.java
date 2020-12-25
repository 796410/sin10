package com.talentica.code.exception;

public class InvoicePrintException extends Exception {

	public InvoicePrintException(String message){
		super(message);
	}

	public InvoicePrintException(String message, Throwable throwable){
		super(message,throwable);
	}

}
