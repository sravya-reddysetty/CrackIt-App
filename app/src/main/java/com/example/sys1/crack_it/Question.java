package com.example.sys1.crack_it;
import java.io.Serializable;
public class Question implements Serializable {
    @com.google.gson.annotations.SerializedName("name")
    private String name;
    @com.google.gson.annotations.SerializedName("round")
    private String round;
    @com.google.gson.annotations.SerializedName("text")
    private String text;
    @com.google.gson.annotations.SerializedName("branch")
    private String branch;
    @com.google.gson.annotations.SerializedName("id")
    private String mId;//most important as id is default schema
    @com.google.gson.annotations.SerializedName("company")
    private String company;
    @com.google.gson.annotations.SerializedName("rating")
    private String rating;
    @com.google.gson.annotations.SerializedName("n")
    public int n;
    public Question(String name,String text) {
        this.setName(name);
        this.setText(text);
    }
    public Question(){}
    public String getRating() { return rating; }
    public final void setRating(String t) { rating = t; }
    public String toString() {
        return getName();
    }
    public final void setName(String n) { name =n; }

    public final void setCompany(String n) { company =n; }
    public final void setBranch(String n){branch=n;}
    public String getName() {
        return name;
    }
    public String getRound(){return round;}
    public final void setRound(String t){round=t;}
    public String getText() { return text; }
    public String getBranch(){return branch;}
    public String getCompany() { return company; }
    public final void setText(String t) { text = t; }
    public boolean equals(Object o) {
        return o instanceof Question && ((Question) o).name.equals(name);
    }
    public String getId() {
        return mId;
    }
    public final void setId(String id) {
        mId = id;
    }
}


