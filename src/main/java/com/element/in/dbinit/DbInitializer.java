package com.element.in.dbinit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.element.in.config.ISModuleConfiguration;
import com.element.in.config.SystemConfiguration;

@Component
public class DbInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private Dbutils ultis;
	@Autowired
	private SystemConfiguration sysConfiguration;
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<ISModuleConfiguration> modules = sysConfiguration.getModules();
		modules.stream().map(ultis::mapRawConfigToData).forEach(ultis::sink);
	}
	
	

}
