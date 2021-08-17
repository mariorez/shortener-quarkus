package org.seariver.shortener.application.port.out;

import org.seariver.shortener.application.domain.Shortener;
import org.seariver.shortener.application.domain.SourceUrl;

public interface ShortenerRepository {

    void create(Shortener shortener);

    Shortener findBySourceUrl(SourceUrl sourceUrl);
}
