package org.avoidfrust.apib.server;

import org.avoidfrust.apib.common.ApiBDto;
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
