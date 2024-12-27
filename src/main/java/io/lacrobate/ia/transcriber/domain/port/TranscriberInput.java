package io.lacrobate.ia.transcriber.domain.port;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface TranscriberInput {
//	@SuppressWarnings("SameParameterValue")
	String getTranscription(String fileName);

	String getTranscription(MultipartFile multiPartFile);
	String getTranscription(InputStream contentStream);
}
