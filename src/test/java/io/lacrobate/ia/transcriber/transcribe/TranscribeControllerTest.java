package io.lacrobate.ia.transcriber.transcribe;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import wiremock.org.hamcrest.Matchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wiremock.org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureWireMock(port = 0)
class TranscribeControllerTest {

	private String urlBase;
	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeAll
	void setUp() {
		urlBase = "http://localhost:8080/transcribe";
	}

	@Test
	void shouldPlaceOrder() {
		String requestBody = """
         {
             "skuCode":"iphone_15",
             "price": 1000,
             "quantity": 1
         }
         """;
		InventoryClientStub.stubInventoryCall("iphone_15", 1);


		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/test-external")
				.then()
				.statusCode(200)
				.extract()
				.body().asString();
		assertThat(responseBodyString, Matchers.is("test_ok"));
	}


	@Test
	@DisplayName("should return xxx when I call transcribe API")
	public void whenICallTranscribeAPI() {
		//    when
		String apiUnderTest = (urlBase + "/%s").formatted("testFile1");
		String result = restTemplate.getForObject(apiUnderTest, String.class);
		//    then
		assertEquals(result, "xxx");
	}


}