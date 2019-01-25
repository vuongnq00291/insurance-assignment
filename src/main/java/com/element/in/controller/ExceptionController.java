package com.element.in.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.element.in.dto.ErrorDTO;
import com.element.in.entity.SysException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({ SysException.class })
	public ResponseEntity<ErrorDTO> handleAll(final Exception ex, final WebRequest request) {
		String error = "";
		if (ex instanceof SysException) {
			SysException e = (SysException) ex;
			error = e.getError();
		} else {
			error = ex.getLocalizedMessage();
		}
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(error, "0"), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}