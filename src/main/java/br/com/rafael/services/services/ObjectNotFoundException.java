package br.com.rafael.services.services;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable caso) {
		super(msg, caso);
	}
	
}
