package com.builders.editorx.modal;

public class TagModel {
    private String tag;
    private int color;

    public TagModel(String tag, int color) {
        this.tag = tag;
        this.color = color;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
