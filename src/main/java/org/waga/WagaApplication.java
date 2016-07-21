package org.waga;

import java.io.File;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.jbake.app.ConfigUtil;
import org.jbake.app.JBakeException;
import org.jbake.app.Oven;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.waga.web.ViewHelper;

//@SpringBootApplication
public class WagaApplication {

	public static void main(String[] args) throws ConfigurationException {
		
		// ConfigurableApplicationContext context = SpringApplication.run(WagaApplication.class, args);
		
		File root = new File(".");

		System.out.println("Running in location: " + root.getAbsolutePath());
		
		// stream my data into collections of results push into configuration objects to get out in template

		File source = new File(root, "/src/main/resources/jbake");

		File destination = new File(root, "/target");

		CompositeConfiguration config = new CompositeConfiguration();
		config.addConfiguration(ConfigUtil.load(source));		
		config.addProperty("robin", "tegg");
		
		config.addProperty("helper", new ViewHelper());
		
		try {
			Oven oven = new Oven(source, destination, config, true);
			oven.setupPaths();
			oven.bake();
		} catch (JBakeException e) {
			// do something with exception here
		}
		
	}

}
