package com.talentyco.chapter03.domain.vo;


import java.util.UUID;

public class SwitchId {

    private final UUID id;

    public SwitchId(UUID id) {
        this.id = id;
    }

    public static SwitchId withId(String id) {
        return new SwitchId(UUID.fromString(id));
    }

    public static SwitchId withoutId() {
        return new SwitchId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "SwitchId{" +
                "id=" + id +
                '}';
    }
}
