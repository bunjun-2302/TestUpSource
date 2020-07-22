package com.example.musicbyjun.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHat {

    @SerializedName("IdBH")
    @Expose
    private String idBH;
    @SerializedName("TenBH")
    @Expose
    private String tenBH;
    @SerializedName("hinhbaihat")
    @Expose
    private String hinhbaihat;
    @SerializedName("CasiBH")
    @Expose
    private String casiBH;
    @SerializedName("LinkBH")
    @Expose
    private String linkBH;
    @SerializedName("LuotthichBH")
    @Expose
    private String luotthichBH;

    public String getIdBH() {
        return idBH;
    }

    public void setIdBH(String idBH) {
        this.idBH = idBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

    public String getCasiBH() {
        return casiBH;
    }

    public void setCasiBH(String casiBH) {
        this.casiBH = casiBH;
    }

    public String getLinkBH() {
        return linkBH;
    }

    public void setLinkBH(String linkBH) {
        this.linkBH = linkBH;
    }

    public String getLuotthichBH() {
        return luotthichBH;
    }

    public void setLuotthichBH(String luotthichBH) {
        this.luotthichBH = luotthichBH;
    }

}