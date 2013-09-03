package com.bt.exception;

public class TokenNotMappingException extends Exception {
	private static final long	serialVersionUID	= 7304686406435303635L;

	public TokenNotMappingException() {
	};

	public TokenNotMappingException(final String message) {
		super(message);
	}
}
