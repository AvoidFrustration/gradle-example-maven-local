package org.avoidfrust.example.gradle.apia.client;

import org.avoidfrust.example.gradle.apia.common.ApiADto;
import org.avoidfrust.example.gradle.apia.client.ApiAClient;
import org.avoidfrust.example.gradle.apia.client.ApiAClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiAClientTest {
    private static final String NAME = "DtoName";
    private ApiAClient client;

    @BeforeEach
    public void createClient() {
        this.client = new ApiAClientImpl();
    }

    @Test
    public void testSent() {
        ApiADto dto = new ApiADto(NAME);
        this.client.send(dto);
    }
}
