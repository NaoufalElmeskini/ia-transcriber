package io.lacrobate.ia.transcriber.domain.transcribe;

import java.io.File;

public record Transcription (File transcribedFile, String transcription) {
}
