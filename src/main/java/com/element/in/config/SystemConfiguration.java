package com.element.in.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties
public class SystemConfiguration {
	
	@Value("${error.wrongpackage.message}")
	private String error;
	@Value("${error.wrongpackage.code}")
	private String errorCode;
	
	private List<ISModuleConfiguration> modules = new ArrayList<ISModuleConfiguration>();

	public List<ISModuleConfiguration> getModules() {
		return modules;
	}

	public void setModules(List<ISModuleConfiguration> modules) {
		this.modules = modules;
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
