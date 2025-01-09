package io.lacrobate.ia.transcriber.domain.port;

import io.lacrobate.ia.transcriber.domain.transcribe.Transcription;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface TranscriberInput {

	Transcription getTranscription(MultipartFile multiPartFile);
	String getTranscription(InputStream contentStream);
}
