package com.rep.interfaces;

interface Named {
    void setName(String name);

    /* from w w w .ja va 2 s . com */
    default String getName() {
        return "John Doe";
    }

    default void setNickname(String nickname) {
        throw new UnsupportedOperationException("setNickname");
    }

    default String getNickname() {
        throw new UnsupportedOperationException("getNickname");
    }
}