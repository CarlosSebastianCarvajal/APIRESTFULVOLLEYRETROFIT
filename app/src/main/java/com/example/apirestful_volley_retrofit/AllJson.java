package com.example.apirestful_volley_retrofit;

public class AllJson {

    private Object meta;

    private Data[] dataArray;

    public Data[] getDataArray() {
        return dataArray;
    }

    public void setDataArray(Data[] dataArray) {
        this.dataArray = dataArray;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}
