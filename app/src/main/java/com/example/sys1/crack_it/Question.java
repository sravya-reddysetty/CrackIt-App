package com.example.sys1.crack_it; /**
 * Created by sys1 on 2/24/2018.
 */
import java.io.Serializable;

public class Question implements Serializable {
    String name;

    public Question(String name) {
        this.name = name;
//here we can add more fields like description,answers etc
    }

    public String getName() {
        return name;
    }
}

