package com.cpscs.omsadmin.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Tt implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id ;
    private  String name;
    private Date ttime;

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
