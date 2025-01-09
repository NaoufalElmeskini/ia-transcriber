package io.lacrobate.ia.transcriber.infrastructure;

import io.lacrobate.ia.transcriber.domain.file.FileUtils;
import io.lacrobate.ia.transcriber.domain.transcribe.Transcription;
import io.lacrobate.ia.transcriber.domain.transcribe.TranscriptionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TranscriptionFSRepository implements TranscriptionRepository {
	@Override
	public void saveTranscription(Transcription transcribtion) {
		FileUtils.saveTranscription(transcribtion);
	}
}
