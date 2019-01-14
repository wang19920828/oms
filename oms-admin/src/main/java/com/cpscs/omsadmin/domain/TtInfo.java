package com.cpscs.omsadmin.domain;

import java.io.Serializable;
import java.util.Date;

public class TtInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id ;
    private  String name;
    private Date ttime;

    private int oid;
    private String ocode;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOcode() {
        return ocode;
    }

    public void setOcode(String ocode) {
        this.ocode = ocode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }
}
