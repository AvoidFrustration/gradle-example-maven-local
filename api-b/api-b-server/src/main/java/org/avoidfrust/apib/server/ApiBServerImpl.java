package org.avoidfrust.apib.server;

import org.avoidfrust.apib.common.ApiBDto;
import org.avoidfrust.util.Util;

public class ApiBServerImpl implements ApiBServer{
    private Util util;

    @Override
    public void receive(ApiBDto dto) {
        ApiBDto newDto = util.convert(dto);
    }
}
