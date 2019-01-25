package com.element.in.entity;

public class SysException extends Exception{
	private String error;
	private String errorCode;
	private static final long serialVersionUID = 1481639874100725832L;
	
	public SysException(String error,String errorCode){
		this.setError(error);
		this.setErrorCode(errorCode);
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
