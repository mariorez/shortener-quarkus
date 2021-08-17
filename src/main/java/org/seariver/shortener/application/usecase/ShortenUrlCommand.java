package org.seariver.shortener.application.usecase;

import org.seariver.shortener.application.domain.SourceUrl;

public class ShortenUrlCommand {

    private SourceUrl sourceUrl;
    private String result;

    public ShortenUrlCommand(SourceUrl sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public SourceUrl getSourceUrl() {
        return sourceUrl;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
