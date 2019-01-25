package com.element.in.repository;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(properties="spring.config.name=application,data")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ModuleRepositoryTest {
   @Autowired(required=true)
   private ModuleRepository moduleRepository;
   
   @Test
   public void findByCodeTest(){
	   List<Module> modules =  (List<Module>) moduleRepository.findAll();
	   assertEquals(modules.size(),4);
	   Module module = modules.get(0);
	   assertEquals(module.getName(),"Bike");
	   assertEquals(module.getCode(),"BIKE");
	   assertEquals(module.getMax(),3000.0,0.00);
	   assertEquals(module.getMin(),0,0.00);
   }
   
 
}
