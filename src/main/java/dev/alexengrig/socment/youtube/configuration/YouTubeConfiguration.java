package dev.alexengrig.socment.youtube.configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
@RequiredArgsConstructor
public class YouTubeConfiguration {
    @Value("${spring.application.name}")
    private final String applicationName;

    @Bean
    public YouTube youTube(
            HttpTransport httpTransport,
            JsonFactory jsonFactory,
            HttpRequestInitializer httpRequestInitializer) {
        return new YouTube.Builder(httpTransport, jsonFactory, httpRequestInitializer)
                .setApplicationName(applicationName)
                .build();
    }

    @Bean
    public HttpTransport httpTransport() throws GeneralSecurityException, IOException {
        return GoogleNetHttpTransport.newTrustedTransport();
    }

    @Bean
    public JsonFactory jsonFactory() {
        return JacksonFactory.getDefaultInstance();
    }

    @Bean
    public HttpRequestInitializer httpRequestInitializer() {
        return request -> {
        };
    }
}
