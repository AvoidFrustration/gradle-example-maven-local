package org.avoidfrust.apia.client;

import org.avoidfrust.apia.common.ApiADto;
import org.avoidfrust.util.Util;

public class ApiAClientImpl implements ApiAClient{
    private Util util;
    @Override
    public void send(ApiADto dto) {
        ApiADto newDto = util.convert(dto);
    }
}
