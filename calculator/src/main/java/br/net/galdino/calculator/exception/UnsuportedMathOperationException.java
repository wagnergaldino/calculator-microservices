package br.net.galdino.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = 4912206236498413304L;

	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}
	
	

}
