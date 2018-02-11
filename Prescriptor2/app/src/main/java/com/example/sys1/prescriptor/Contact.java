package com.example.sys1.prescriptor;

import android.provider.BaseColumns;

/**
 * Created by sys1 on 9/25/2017.
 */

public class Contact {
    public static final class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME="contactlist";
        public static final String COL_USERNAME="username";
        public static final String COL_EMAIL="email";
        public static final String COL_PASSWORD="password";

    String cname;
    String cpassword;
    String cemail;
    /*public Contact()
    {}
    public Contact(String email,String name,String password)
    {
        cemail=email;
        cname=name;
        cpassword=password;
    }
    public Contact(String name,String password)
    {

        cname=name;
        cpassword=password;
    }*/
    public String getEmail()
    {
        return this.cemail;
    }
    public void setEmail(String email)
    {
        cemail=email;
    }
    public String getUsername()
    {
        return this.cname;
    }
    public void setUsername(String name)
    {
        cname=name;
    }
    public String getPassword()
    {
        return  this.cpassword;
    }
    public void setPassword(String password)
    {
        cpassword=password;
    }}

}
