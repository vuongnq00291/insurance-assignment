package com.element.in.repository;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import com.element.in.entity.Package;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(properties="spring.config.name=application,data")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class PackageRepositoryTest {
   @Autowired(required=true)
   private PackageRepository packageRepository;
   
   @Test
   public void findByCodeTest(){
	   Package pack = packageRepository.findByCode("BIKE-2000");
	   assertEquals(pack.getCode(),"BIKE-2000");
	   assertEquals(pack.getCouverage(),2000,0.00);
	   assertEquals(pack.getPrice(),600,0.00);
   }
   
 
}
