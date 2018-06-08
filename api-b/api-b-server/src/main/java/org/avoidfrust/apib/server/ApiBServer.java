package org.avoidfrust.apib.server;

import org.avoidfrust.apib.common.ApiBDto;

public interface ApiBServer {
    void receive(ApiBDto dto);
}
