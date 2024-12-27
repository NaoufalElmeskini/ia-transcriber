package io.lacrobate.ia.transcriber.domain.port;

import org.springframework.web.multipart.MultipartFile;

public interface TranscriberInput {
//	@SuppressWarnings("SameParameterValue")
	String getTranscription(String fileName);

	String getTranscription(MultipartFile multiPartFile);
}
