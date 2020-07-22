package com.example.musicbyjun.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TheLoai implements Serializable {

    @SerializedName("IdTL")
    @Expose
    private String idTL;
    @SerializedName("TenTL")
    @Expose
    private String tenTL;
    @SerializedName("HinhTL")
    @Expose
    private String hinhTL;
    @SerializedName("IdFKchude")
    @Expose
    private String idFKchude;

    public String getIdTL() {
        return idTL;
    }

    public void setIdTL(String idTL) {
        this.idTL = idTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public String getHinhTL() {
        return hinhTL;
    }

    public void setHinhTL(String hinhTL) {
        this.hinhTL = hinhTL;
    }

    public String getIdFKchude() {
        return idFKchude;
    }

    public void setIdFKchude(String idFKchude) {
        this.idFKchude = idFKchude;
    }

}