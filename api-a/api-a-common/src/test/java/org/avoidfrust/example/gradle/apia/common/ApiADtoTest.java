package org.avoidfrust.example.gradle.apia.common;

import org.avoidfrust.example.gradle.apia.common.ApiADto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ApiADtoTest {
    private static final String NAME = "DtoName";

    @Test
    public void testName() {
        ApiADto dto = new ApiADto(NAME);
        assertSame(NAME, dto.getName());
    }


}
