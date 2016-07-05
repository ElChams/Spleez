package com.slpeez.spleez.Object;

import java.util.Date;

/**
 * Created by thibaut on 17/03/2016.
 */
public class Event {;

    private int _id;
    private String _name;
    private String _desc;
    private Date _date;

    public Event() {
        _id = 0;
        _date = null;
        _name = "";
        _desc = "";
    }

    public void setId(int id) {
        _id = id;
    }
    public int getId() {
        return _id;
    }

    public void setName(String name) {
        _name = name;
    }
    public String getName() {
        return _name;
    }

    public void setDesc(String desc) {
        _desc = desc;
    }
    public String getDesc() {
        return _desc;
    }

    public void setDate(Date date) {
        _date = date;
    }
    public Date getDate() {
        return _date;
    }
}
