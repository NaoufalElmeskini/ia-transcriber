package io.lacrobate.ia.transcriber.wiremock_feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InventoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	private InventoryClient client;

	@PostMapping("/test-external")
	public String testExternal(){
		LOGGER.info("processing testExternal...");
		client.isInStock("iphone_15", 1);
		return "test_ok";
	}
}
