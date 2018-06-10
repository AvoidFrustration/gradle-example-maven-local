package org.avoidfrust.example.gradle.apib.server;

import org.avoidfrust.example.gradle.apib.common.ApiBDto;

public interface ApiBServer {
    void receive(ApiBDto dto);
}
