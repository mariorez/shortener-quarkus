package org.seariver.shortener.application.domain;

public class ShortCode {

    private final String code;

    public ShortCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
