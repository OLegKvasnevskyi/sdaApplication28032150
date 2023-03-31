package com.example.sdaApplication.model;

public enum IdentifierEnum {
    MEETING_ROOM("MEETING_ROOM"),
    CONFERENCE_ROOM("CONFERENCE_ROOM");

    private final String identifier;

    IdentifierEnum(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}