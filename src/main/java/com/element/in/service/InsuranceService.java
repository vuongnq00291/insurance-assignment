package com.element.in.service;

import java.util.List;

import com.element.in.entity.Module;
import com.element.in.entity.Package;

public interface InsuranceService {
	
	public List<Module> findallModules();
	public Package findInsurancePackageByCode(String code);
	public double computePrice(double couverage,double risk);

}
