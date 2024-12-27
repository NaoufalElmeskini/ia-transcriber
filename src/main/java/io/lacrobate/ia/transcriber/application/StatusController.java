package io.lacrobate.ia.transcriber.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.lacrobate.ia.transcriber.application.StatusController.NAME;

@RestController
@RequestMapping(NAME)
public class StatusController {
	public static final String NAME = "/status";

	@GetMapping
	public HttpStatus status() {
		return HttpStatus.ACCEPTED;
	}
}
