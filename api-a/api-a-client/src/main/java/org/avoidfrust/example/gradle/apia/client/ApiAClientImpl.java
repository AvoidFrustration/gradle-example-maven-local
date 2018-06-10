package org.avoidfrust.example.gradle.apia.client;

import org.avoidfrust.example.gradle.apia.common.ApiADto;
import org.avoidfrust.util.Util;

public class ApiAClientImpl implements ApiAClient{
    private Util util;
    @Override
    public void send(ApiADto dto) {
        ApiADto newDto = util.convert(dto);
    }
}
