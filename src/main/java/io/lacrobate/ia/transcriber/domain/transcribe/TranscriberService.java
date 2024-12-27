package io.lacrobate.ia.transcriber.domain.transcribe;

import io.lacrobate.ia.transcriber.domain.file.FileUtils;
import io.lacrobate.ia.transcriber.domain.port.TranscriberInput;
import io.lacrobate.ia.transcriber.domain.port.TranscriberOutput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.lacrobate.ia.transcriber.domain.file.FileUtils.copyToLocalFile;
import static io.lacrobate.ia.transcriber.domain.file.FileUtils.createTranscriptFile;

@Service
@AllArgsConstructor
@Slf4j
public class TranscriberService implements TranscriberInput {

	private final TranscriberOutput output;

	@Override
	public String getTranscription(String fileName) {
		Path transcriptionFilePath = createTranscriptFile(fileName);
		Path audioFilePath = Paths.get(FileUtils.INPUT_RESOURCES_PATH, fileName + ".wav");

		if (Files.exists(transcriptionFilePath)) {
			try {
				return Files.readString(transcriptionFilePath);
			} catch (IOException e) {
				System.err.println("Error reading transcription file: " + e.getMessage());
			}
		} else {
			return output.transcribe(audioFilePath.toString());
		}
		return "";
	}

	@Override
	public String getTranscription(InputStream contentStream) {
		log.info("getTranscription...");
		try {
			return output.transcribe(contentStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getTranscription(MultipartFile multiPartFile){
		return output.transcribe(copyToLocalFile(multiPartFile));
	}
}
