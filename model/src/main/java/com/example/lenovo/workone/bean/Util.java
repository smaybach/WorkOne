package com.example.lenovo.workone.bean;


public class Util {
    public Util() {
        super();
    }
    public Util(int tu, String namel, String content) {
        super();
        this.tu = tu;
        this.namel = namel;
        this.content = content;
    }
    private int tu;
    private String namel;
    private String content;
    public int getTu() {
        return tu;
    }
    public void setTu(int tu) {
        this.tu = tu;
    }
    public String getNamel() {
        return namel;
    }
    public void setNamel(String namel) {
        this.namel = namel;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Util [tu=" + tu + ", namel=" + namel + ", content=" + content
                + "]";
    }



}
