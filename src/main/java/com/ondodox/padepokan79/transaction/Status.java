package com.ondodox.padepokan79.transaction;

public enum Status {
    DEBIT("Debit"),
    CREDIT("Credit");

    private final String value;

    Status(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
