package org.waga;

import java.io.File;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.jbake.app.ConfigUtil;
import org.jbake.app.JBakeException;
import org.jbake.app.Oven;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.waga.core.ViewHelper;

//@SpringBootApplication
public class WagaApplication {

	private static final Logger log = LoggerFactory.getLogger(WagaApplication.class);

	public static void main(String[] args) throws ConfigurationException {

		log.info("Compiling data");

		WagaData data = WagaDataCompiler.compile();

		// ConfigurableApplicationContext context =
		// SpringApplication.run(WagaApplication.class, args);

		log.info("Applying calculations");

		log.info("Start the bake");

		File root = new File(".");

		log.info("Running in location: {}", root.getAbsolutePath());

		File source = new File(root, "/src/main/resources/jbake");

		File destination = new File(root, "/target");

		CompositeConfiguration config = new CompositeConfiguration();
		config.addConfiguration(ConfigUtil.load(source));
		config.addProperty("robin", "tegg");
		config.addProperty("helper", new ViewHelper());
		config.addProperty("data", data);

		try {
			Oven oven = new Oven(source, destination, config, true);
			oven.setupPaths();
			oven.bake();
		} catch (JBakeException e) {
			// do something with exception here
			e.printStackTrace();
		}

	}

}
