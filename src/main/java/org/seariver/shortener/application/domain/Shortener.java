package org.seariver.shortener.application.domain;

public class Shortener {

    private SourceUrl sourceUrl;
    private ShortCode shortCode;

    public SourceUrl getSourceUrl() {
        return sourceUrl;
    }

    public Shortener setSourceUrl(SourceUrl sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public ShortCode getShortCode() {
        return shortCode;
    }

    public Shortener setShortCode(ShortCode shortCode) {
        this.shortCode = shortCode;
        return this;
    }
}
