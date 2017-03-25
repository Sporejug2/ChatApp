package com.example.egac.thechatapp;

/**
 * Created by Egac on 2/9/2017.
 */

public class Listitem {

    private String head;
    private String desc;
    private String time;

    public Listitem(String head, String desc, String time) {
        this.head = head;
        this.desc = desc;
        this.time = time;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }
}
