package org.avoidfrust.apib.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiBDtoTest {
    private static final String NAME = "DtoName";

    @Test
    public void testName() {
        ApiBDto dto = new ApiBDto(NAME);
        assertSame(NAME, dto.getName());
    }

}
