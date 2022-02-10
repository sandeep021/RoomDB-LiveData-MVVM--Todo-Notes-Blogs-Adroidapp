package com.sandeep.github01.retrofit;

public class BaseDataModel {
    private String tag;
    private Object object;

    public BaseDataModel(String tag, Object object) {
        this.tag = tag;
        this.object = object;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
