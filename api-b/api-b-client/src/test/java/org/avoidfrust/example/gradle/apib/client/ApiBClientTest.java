package org.avoidfrust.example.gradle.apib.client;

import org.avoidfrust.example.gradle.apib.common.ApiBDto;
import org.avoidfrust.example.gradle.apib.client.ApiBClient;
import org.avoidfrust.example.gradle.apib.client.ApiBClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiBClientTest {
    private static final String NAME = "DtoName";
    private ApiBClient client;

    @BeforeEach
    public void createClient() {
        this.client = new ApiBClientImpl();
    }

    @Test
    public void testSent() {
        ApiBDto dto = new ApiBDto(NAME);
        this.client.send(dto);
    }
}
