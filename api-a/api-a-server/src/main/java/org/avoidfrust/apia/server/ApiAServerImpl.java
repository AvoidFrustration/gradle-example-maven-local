package org.avoidfrust.apia.server;

import org.avoidfrust.apia.common.ApiADto;
import org.avoidfrust.util.Util;

public class ApiAServerImpl implements ApiAServer{
    private Util util;

    @Override
    public void receive(ApiADto dto) {
        ApiADto newDto = util.convert(dto);

    }
}
