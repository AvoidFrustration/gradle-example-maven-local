package org.avoidfrust.example.gradle.apib.client;

import org.avoidfrust.example.gradle.apib.common.ApiBDto;
import org.avoidfrust.util.Util;

public class ApiBClientImpl implements ApiBClient{
    private Util util;

    @Override
    public void send(ApiBDto dto) {
        ApiBDto newDto = util.convert(dto);
    }
}
