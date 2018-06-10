package org.avoidfrust.apib.client;

import org.avoidfrust.apib.common.ApiBDto;
import org.avoidfrust.util.Util;

public class ApiBClientImpl implements ApiBClient{
    private Util util;

    @Override
    public void send(ApiBDto dto) {
        ApiBDto newDto = util.convert(dto);
    }
}
