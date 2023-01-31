package pl.piomin.samples.micronaut.oauth2;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class SampleControllerTests {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/secure")
    HttpClient client;

    @Test
    void anonymous() {
        String response = client.toBlocking().retrieve("/anonymous", String.class);
        assertNotNull(response);
    }

}
