package com.example.sdaApplication.model;

public enum AvailabilityEnum {
    RESERVATION("RESERVATION"),
    FREE("FREE");
    private final String availability;

    AvailabilityEnum(String availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return availability;
    }
}
