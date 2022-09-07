package com.ondodox.padepokan79.transaction;

public enum Description {
    ST("Setor Tunai"),
    TT("Tarik Tunai"),
    BP("Beli Pulsa"),
    BL("Bayar Listrik");

    private final String value;

    Description(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}