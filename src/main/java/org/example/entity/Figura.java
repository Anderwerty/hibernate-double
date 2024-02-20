package org.example.entity;

import org.hibernate.annotations.Formula;

public class Figura {

    public int width;

    private int height;

    @Formula("width*height")
    private int area;

}
