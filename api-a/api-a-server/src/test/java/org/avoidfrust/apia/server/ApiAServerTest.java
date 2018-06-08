package org.avoidfrust.apia.server;

import org.avoidfrust.apia.common.ApiADto;
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
