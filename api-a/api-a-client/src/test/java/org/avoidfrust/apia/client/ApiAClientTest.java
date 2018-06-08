package org.avoidfrust.apia.client;

import org.avoidfrust.apia.common.ApiADto;
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
