package org.seariver.shortener.adapter.out;

import org.seariver.shortener.application.domain.Shortener;
import org.seariver.shortener.application.domain.SourceUrl;
import org.seariver.shortener.application.port.out.ShortenerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@ApplicationScoped
public class ShortenerRepositoryImpl implements ShortenerRepository {

    private final DataSource dataSource;

    public ShortenerRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Shortener shortener) {

        var sql = "INSERT INTO shortener (source_url, short_code) values (?, ?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, shortener.getSourceUrl().getUrl());
            stmt.setString(2, shortener.getShortCode().getCode());
            stmt.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Shortener findBySourceUrl(SourceUrl sourceUrl) {
        return null;
    }
}
