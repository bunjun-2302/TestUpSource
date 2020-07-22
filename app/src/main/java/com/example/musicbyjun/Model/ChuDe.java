package com.example.musicbyjun.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDe implements Serializable {

    @SerializedName("IdCHUDE")
    @Expose
    private String idCHUDE;
    @SerializedName("TenCHUDE")
    @Expose
    private String tenCHUDE;
    @SerializedName("HinhCHUDE")
    @Expose
    private String hinhCHUDE;

    public String getIdCHUDE() {
        return idCHUDE;
    }

    public void setIdCHUDE(String idCHUDE) {
        this.idCHUDE = idCHUDE;
    }

    public String getTenCHUDE() {
        return tenCHUDE;
    }

    public void setTenCHUDE(String tenCHUDE) {
        this.tenCHUDE = tenCHUDE;
    }

    public String getHinhCHUDE() {
        return hinhCHUDE;
    }

    public void setHinhCHUDE(String hinhCHUDE) {
        this.hinhCHUDE = hinhCHUDE;
    }

}