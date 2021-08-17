package org.seariver.shortener.application.usecase;

import org.seariver.shortener.application.domain.ShortCode;
import org.seariver.shortener.application.domain.Shortener;
import org.seariver.shortener.application.port.out.ShortenerRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class ShortenUrlHandler {

    private final ShortenerRepository repository;
    private final Random random = new Random();

    public ShortenUrlHandler(ShortenerRepository repository) {
        this.repository = repository;
    }

    public void handle(ShortenUrlCommand command) {

        var charPool = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        var poolSize = charPool.size();

        var code = Stream.of(1, 2, 3, 4, 5)
                .map(i -> random.nextInt(poolSize))
                .map(charPool::get)
                .collect(Collectors.joining());

        var shortener = new Shortener()
                .setSourceUrl(command.getSourceUrl())
                .setShortCode(new ShortCode(code));

        repository.create(shortener);

        command.setResult("http://seariver.org/" + code);
    }
}
