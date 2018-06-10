package org.avoidfrust.example.gradle.apia.server;

import org.avoidfrust.example.gradle.apia.common.ApiADto;

public interface ApiAServer {
    void receive(ApiADto dto);
}
