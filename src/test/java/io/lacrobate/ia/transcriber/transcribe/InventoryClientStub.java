package io.lacrobate.ia.transcriber.transcribe;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {
	public static void stubInventoryCall(String skuCode, Integer quantity) {
		System.out.println("Stubbing inventory call for skuCode: " + skuCode + " and quantity: " + quantity);
		stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity)).willReturn(
				aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody("true")));
	}
}
