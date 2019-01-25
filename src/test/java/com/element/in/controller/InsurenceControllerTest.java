package com.element.in.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.element.in.config.SystemConfiguration;
import com.element.in.dto.ErrorDTO;
import com.element.in.dto.ModuleDTO;
import com.element.in.dto.PackageDTO;
import com.element.in.entity.Module;
import com.element.in.entity.Package;
import com.element.in.service.InsuranceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
public class InsurenceControllerTest {
	private MockMvc mockMvc;
	@Mock
	private InsuranceService insuranceService;

	@Mock 
	ModelMapper mapper;
	@Mock
	private SystemConfiguration config;
	@InjectMocks
	private InsurenceController controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
	            .setControllerAdvice(new ExceptionController())
	            .build();
	}

	@Test
	public void getAllModules() throws Exception {
		
		Module module = new Module();
		module.setName("UTEST");
		module.setCode("UTEST");
		module.setMax(1000);
		module.setMin(0);
		module.setRisk(0.5);
		module.setPackages(new ArrayList<>());
		Package pack = new Package();
		pack.setCode("UTEST-500");
		pack.setCouverage(500);
		pack.setPrice(250);
		module.getPackages().add(pack);
		List<Module> modules = new ArrayList<>();
		modules.add(module);
		when(insuranceService.findallModules()).thenReturn(modules);
		when(mapper.map(module, ModuleDTO.class)).thenReturn(new ModelMapper().map(module, ModuleDTO.class));
		MvcResult result = mockMvc.perform(get("/element.in/insurance/modules"))
	            .andExpect(status().isOk())
				.andReturn();
		ObjectMapper mapper = new ObjectMapper();
		final TypeReference<ArrayList<ModuleDTO>>  type = new TypeReference<ArrayList<ModuleDTO>>() {
		};
		List<ModuleDTO> res = mapper.readValue(result.getResponse().getContentAsString(),type);
		assertEquals(res.size(), 1);
	}
	
	
	@Test
	public void getPackageTest() throws Exception {
		String packcode= "UTEST-500";
		Package pack = new Package();
		pack.setCode(packcode);
		pack.setCouverage(500);
		pack.setPrice(250);
		when(insuranceService.findInsurancePackageByCode(packcode)).thenReturn(pack);
		when(mapper.map(pack, PackageDTO.class)).thenReturn(new ModelMapper().map(pack, PackageDTO.class));
		MvcResult result = mockMvc.perform(get("/element.in/insurance/package/"+packcode))
	            .andExpect(status().isOk())
				.andReturn();
		ObjectMapper mapper = new ObjectMapper();
		PackageDTO res = mapper.readValue(result.getResponse().getContentAsString(),PackageDTO.class);
		assertEquals(res.getCode(), packcode);
		assertEquals(res.getPrice(), 250,0);
		assertEquals(res.getCouverage(), 500,0);
	}
	
	@Test
	public void wrongPackageCodeTest() throws Exception {
		String packcode= "UTEST-500-Wrong";
		when(insuranceService.findInsurancePackageByCode(packcode)).thenReturn(null);
		when(config.getErrorCode()).thenReturn("0");
		when(config.getError()).thenReturn( "Insurance code is not found.");
		MvcResult result =mockMvc.perform(get("/element.in/insurance/package/"+packcode))
	            .andExpect(status().isNotFound())
				.andReturn();
		ObjectMapper jsonmapper = new ObjectMapper();
		ErrorDTO res = jsonmapper.readValue(result.getResponse().getContentAsString(),ErrorDTO.class);
		assertEquals(res.getErrorCode(), "0");
		assertEquals(res.getError(), "Insurance code is not found.");
		
	}


}
