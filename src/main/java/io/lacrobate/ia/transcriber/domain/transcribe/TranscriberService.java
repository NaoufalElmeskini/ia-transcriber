package io.lacrobate.ia.transcriber.domain.transcribe;

import io.lacrobate.ia.transcriber.domain.file.FileUtils;
import io.lacrobate.ia.transcriber.domain.port.TranscriberInput;
import io.lacrobate.ia.transcriber.domain.port.TranscriberOutput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Service
@AllArgsConstructor
@Slf4j
public class TranscriberService implements TranscriberInput {

	private final TranscriberOutput output;
	private final TranscriptionRepository repository;


	@Override
	public String getTranscription(InputStream contentStream) {
		try {
			log.info("getTranscription...");
			return output.transcribe(contentStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Transcription getTranscription(MultipartFile multiPartFile){
		File file = FileUtils.saveFile(multiPartFile);
		Transcription transcribtion = output.transcribe(file);
		repository.saveTranscription(transcribtion);

		return transcribtion;
	}
}
