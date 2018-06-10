package org.avoidfrust.apia.common;

public class ApiADto {
    public final String name;
    public String type;

    public ApiADto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
