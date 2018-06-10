package org.avoidfrust.example.gradle.apib.server;

import org.avoidfrust.example.gradle.apib.common.ApiBDto;
import org.avoidfrust.util.Util;

public class ApiBServerImpl implements ApiBServer{
    private Util util;

    @Override
    public void receive(ApiBDto dto) {
        ApiBDto newDto = util.convert(dto);
    }
}
