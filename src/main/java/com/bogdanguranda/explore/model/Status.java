package com.bogdanguranda.explore.model;

public enum Status {
    OK("OK"), NOT_OK("!OK"), TODO("TODO"), EN_ROUTE("En route");

    private String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
