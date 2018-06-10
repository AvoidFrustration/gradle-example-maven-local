package org.avoidfrust.example.gradle.apib.common;

public class ApiBDto {
    private final String name;
    private String type;

    public ApiBDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
