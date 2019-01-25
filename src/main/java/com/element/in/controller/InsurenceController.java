package com.element.in.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.element.in.annotation.ISController;
import com.element.in.config.SystemConfiguration;
import com.element.in.dto.ModuleDTO;
import com.element.in.dto.PackageDTO;
import com.element.in.entity.Module;
import com.element.in.entity.Package;
import com.element.in.entity.SysException;
import com.element.in.service.InsuranceService;
@ISController
public class InsurenceController {
	@Autowired
	private InsuranceService insuranceService;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private SystemConfiguration config;
	
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	@RequestMapping(value = "/modules",method=RequestMethod.GET)
	public List<ModuleDTO> modules() throws Exception{
		
		List<Module> modules = insuranceService.findallModules();
		List<ModuleDTO> mdto =  modules.stream().filter(s->s!=null).map(s->convertToModuleDto(s)).collect(Collectors.toList());
		return mdto;
	}
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	@RequestMapping(value = "/package/{packageCode}",method=RequestMethod.GET)
	public PackageDTO pack(@PathVariable(name="packageCode")String code) throws Exception{
		
    	Package pack = insuranceService.findInsurancePackageByCode(code);
    	if(pack==null){
    		throw new SysException(config.getError(),config.getErrorCode());
    	}
    	PackageDTO mdto = convertToPackageDto(pack);
		return mdto;
	}
	
	public ModuleDTO convertToModuleDto(Module module) {
		ModuleDTO dto = mapper.map(module, ModuleDTO.class);
        return dto;
    }
	public PackageDTO convertToPackageDto(Package pack) {
		PackageDTO dto = mapper.map(pack, PackageDTO.class);
        return dto;
    }
	
	
}
