package io.lacrobate.ia.transcriber.application;

import io.lacrobate.ia.transcriber.domain.port.TranscriberInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/transcribe")
@Slf4j
public class TranscribeController {

	@Autowired
	private TranscriberInput transcriberInput;

	@PostMapping(value = "/attached",
			consumes = MULTIPART_FORM_DATA_VALUE,
			produces = { "application/json", "application/xml" })
	public String transcribe(
			@RequestParam String fileName,
			@RequestPart MultipartFile file) {
		log.info("transcribing: {}", file.getOriginalFilename());
		return transcriberInput.getTranscription(file).transcription();
	}

}
