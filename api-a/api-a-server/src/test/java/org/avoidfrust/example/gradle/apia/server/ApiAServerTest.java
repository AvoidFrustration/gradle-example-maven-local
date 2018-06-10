package org.avoidfrust.example.gradle.apia.server;

import org.avoidfrust.example.gradle.apia.common.ApiADto;
import org.avoidfrust.example.gradle.apia.server.ApiAServer;
import org.avoidfrust.example.gradle.apia.server.ApiAServerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiAServerTest {
    private static final String NAME = "DtoName";
    private ApiAServer server;

    @BeforeEach
    public void createServer() {
        this.server = new ApiAServerImpl();
    }

    @Test
    public void testReceive() {
        ApiADto dto = new ApiADto(NAME);
        this.server.receive(dto);
    }
}
