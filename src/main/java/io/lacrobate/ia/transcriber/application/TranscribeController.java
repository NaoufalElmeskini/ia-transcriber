package io.lacrobate.ia.transcriber.application;

import io.lacrobate.ia.transcriber.domain.port.TranscriberInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/transcribe")
public class TranscribeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TranscribeController.class);
	@Autowired
	private TranscriberInput transcriberInput;

	@GetMapping("/{fileName}")
	public String transcribe(@PathVariable("fileName") String fileName){
		LOGGER.info("transcribing {}", fileName);
		return transcriberInput.getTranscription(fileName);
	}

	@PostMapping(value = "/attached",
			consumes = MULTIPART_FORM_DATA_VALUE,
			produces = { "application/json", "application/xml" })
	public String transcribe(
			@RequestParam String fileName,
			@RequestPart MultipartFile file) throws IOException {
		LOGGER.info("transcribing: {}", file.getOriginalFilename());
		return transcriberInput.getTranscription(file);
	}

}
