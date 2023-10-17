package api;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type
{
    EDUCATION("education"),
    RECREATIONAL("recreational"),
    SOCIAL("social"),
    DIY("diy"),
    CHARITY("charity"),
    COOKING("cooking"),
    RELAXATION("relaxation"),
    MUSIC("music"),
    BUSYWORK("busywork");

    private final String value;

    Type(String value)
    {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString()
    {
        return value;
    }
}
