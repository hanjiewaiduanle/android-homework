package com.example.newbee;

public class AvatarItem {
    private int imageResId;
    private String name;

    public AvatarItem(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}