package com.element.in.dto;

import java.util.List;


public class ModuleDTO {
	
	private  String name;
	private  String code;
    private  double max;
    private  double min;
    private  double risk;
	
    private List<PackageDTO> packages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getRisk() {
		return risk;
	}

	public void setRisk(double risk) {
		this.risk = risk;
	}

	public List<PackageDTO> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageDTO> packages) {
		this.packages = packages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	

}
