package com.element.in.dbinit;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.element.in.config.ISModuleConfiguration;
import com.element.in.entity.Module;
import com.element.in.entity.Package;
import com.element.in.repository.ModuleRepository;
import com.element.in.service.InsuranceService;

@Component
public class Dbutils {
	
	@Autowired
	private ModuleRepository insuranceModuleRepository;
	@Autowired
	private InsuranceService insuranceService;
	
	@Transactional
	public void sink(Module module){
		insuranceModuleRepository.save(module);
	}
	
	public Module mapRawConfigToData(ISModuleConfiguration raw){
		Module module = new Module();
		module.setCode(raw.getCode());
		module.setMax(raw.getMax());
		module.setMin(raw.getMin());
		module.setName(raw.getName());
		module.setRisk(raw.getRisk());
		module.setPackages(new ArrayList<>());
		raw.getPackages().forEach(coverage->{
			Package pack = new Package();
			pack.setCode(raw.getCode()+"-"+String.valueOf(coverage));
			pack.setCouverage(coverage);
			pack.setModule(module);
			pack.setPrice(insuranceService.computePrice(pack.getCouverage(), raw.getRisk()));
			module.getPackages().add(pack);
		});
	    return module;
	}
}
