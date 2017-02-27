package com.jdkgroup.loadmore.retrofit2;

import java.io.Serializable;

public class Model implements Serializable{
    String title;
    String rating;
    String type;

    public Model(String type) {
        this.type = type;
    }
}
