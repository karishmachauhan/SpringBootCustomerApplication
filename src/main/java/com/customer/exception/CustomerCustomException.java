/**
 * 
 */
package com.customer.exception;

import org.springframework.http.HttpStatus;

/**
 * @author karishmachauhan
 *
 */
public class CustomerCustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private final HttpStatus httpStatus;
    private final String message;

	public CustomerCustomException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
        this.message = message;
	}

	
	public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
