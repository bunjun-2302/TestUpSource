package com.example.musicbyjun.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("IdQC")
    @Expose
    private String idQC;
    @SerializedName("hinhQC")
    @Expose
    private String hinhQC;
    @SerializedName("noidungQC")
    @Expose
    private String noidungQC;
    @SerializedName("IdBH")
    @Expose
    private String idBH;
    @SerializedName("tenBH")
    @Expose
    private String tenBH;
    @SerializedName("hinhBH")
    @Expose
    private String hinhBH;

    public String getIdQC() {
        return idQC;
    }

    public void setIdQC(String idQC) {
        this.idQC = idQC;
    }

    public String getHinhQC() {
        return hinhQC;
    }

    public void setHinhQC(String hinhQC) {
        this.hinhQC = hinhQC;
    }

    public String getNoidungQC() {
        return noidungQC;
    }

    public void setNoidungQC(String noidungQC) {
        this.noidungQC = noidungQC;
    }

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

    public String getHinhBH() {
        return hinhBH;
    }

    public void setHinhBH(String hinhBH) {
        this.hinhBH = hinhBH;
    }

}