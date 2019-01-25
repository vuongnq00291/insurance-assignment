package com.element.in.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.element.in.entity.Module;
import com.element.in.entity.Package;
import com.element.in.repository.ModuleRepository;
import com.element.in.repository.PackageRepository;
import com.element.in.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	@Autowired
	private ModuleRepository insuranceModuleRepository;
	@Autowired
	private PackageRepository packageRepository;
	public List<Module> findallModules(){
		return (List<Module>) insuranceModuleRepository.findAll();
	}
	
	public Package findInsurancePackageByCode(String code){
		return packageRepository.findByCode(code);
	}
	public double computePrice(double couverage,double risk){
		return couverage*risk;
	}

}
