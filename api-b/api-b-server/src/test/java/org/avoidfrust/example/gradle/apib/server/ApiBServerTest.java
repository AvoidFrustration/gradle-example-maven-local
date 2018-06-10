package org.avoidfrust.example.gradle.apib.server;

import org.avoidfrust.example.gradle.apib.common.ApiBDto;
import org.avoidfrust.example.gradle.apib.server.ApiBServer;
import org.avoidfrust.example.gradle.apib.server.ApiBServerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiBServerTest {
    private static final String NAME = "DtoName";
    private ApiBServer server;

    @BeforeEach
    public void createServer() {
        this.server = new ApiBServerImpl();
    }

    @Test
    public void testReceive() {
        ApiBDto dto = new ApiBDto(NAME);
        this.server.receive(dto);
    }
}
