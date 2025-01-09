package io.lacrobate.ia.transcriber.domain.port;

import io.lacrobate.ia.transcriber.domain.transcribe.Transcription;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface TranscriberOutput {
	String transcribe(String fileName);
	String transcribe(InputStream contentStream) throws IOException;
	Transcription transcribe(File file);
}
