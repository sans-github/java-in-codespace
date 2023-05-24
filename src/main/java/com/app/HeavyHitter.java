package com.app;

public class HeavyHitter {
    private String id;
    private Integer frequency;

    public HeavyHitter(String id, Integer frequency) {
        this.id = id;
        this.frequency = frequency;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}