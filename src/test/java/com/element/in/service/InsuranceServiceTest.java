package com.element.in.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.element.in.entity.Module;
import com.element.in.entity.Package;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(properties="spring.config.name=application,data")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class InsuranceServiceTest {
   @Autowired(required=true)
   private InsuranceService insuranceService;
   
   @Test
   public void findallModulesTest(){
	   List<Module> modules =  insuranceService.findallModules();
	   assertEquals(modules.size(),4);
	   Module module = modules.get(0);
	   assertEquals(module.getName(),"Bike");
	   assertEquals(module.getCode(),"BIKE");
	   assertEquals(module.getMax(),3000.0,0.00);
	   assertEquals(module.getMin(),0,0.00);
   }
   @Test
   public void findInsurancePackageByCodeTest(){
	   Package pack = insuranceService.findInsurancePackageByCode("BIKE-2000");
	   assertEquals(pack.getCode(),"BIKE-2000");
	   assertEquals(pack.getCouverage(),2000,0.00);
	   assertEquals(pack.getPrice(),600,0.00);
   }
   @Test
   public void computePriceTest(){
	  double result =  insuranceService.computePrice(1000, 0.5);
	  assertEquals(result,500,0.00);
   }
}