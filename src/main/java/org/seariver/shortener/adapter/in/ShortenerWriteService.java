package org.seariver.shortener.adapter.in;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import org.seariver.protogen.ShortenRequest;
import org.seariver.protogen.ShortenerResponse;
import org.seariver.protogen.ShortenerWriteServiceGrpc.ShortenerWriteServiceImplBase;
import org.seariver.shortener.application.domain.SourceUrl;
import org.seariver.shortener.application.usecase.ShortenUrlCommand;
import org.seariver.shortener.application.usecase.ShortenUrlHandler;

@GrpcService
public class ShortenerWriteService extends ShortenerWriteServiceImplBase {

    private final ShortenUrlHandler handler;

    public ShortenerWriteService(ShortenUrlHandler handler) {
        this.handler = handler;
    }

    @Override
    public void createShortenedUrl(ShortenRequest request, StreamObserver<ShortenerResponse> responseObserver) {

        var command = new ShortenUrlCommand(new SourceUrl(request.getSourceUrl()));
        handler.handle(command);

        var response = ShortenerResponse
                .newBuilder()
                .setSourceUrl(command.getSourceUrl().getUrl())
                .setShortenedUrl(command.getResult())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
