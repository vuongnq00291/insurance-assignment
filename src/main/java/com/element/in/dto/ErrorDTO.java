package com.element.in.dto;

public class ErrorDTO {
	private String error;
	private String errorCode;
	public ErrorDTO(){};
	public ErrorDTO(String error,String errorCode){
		this.error = error;
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
