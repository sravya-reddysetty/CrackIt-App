package com.example.sys1.sravya;

/**
 * Created by sys1 on 10/3/2017.
 */

public class DatabaseObject {
    String name,phone,loc;
    public DatabaseObject(String name,String loc,String pone){
        this.name=name;
        this.phone=phone;
        this.loc=loc;
    }
    public String getName(){return name;
    }
    public String getPhone(){return phone;}
    public String getLoc(){return loc;}
}
