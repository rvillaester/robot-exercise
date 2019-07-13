package com.robot;

import lombok.Data;

@Data
public class RectangularTableDimension {

    private int length;
    private int width;

    public RectangularTableDimension(){
        this(5);
    }

    public RectangularTableDimension(int length){
        this.width = length;
        this.length = length;
    }

    public RectangularTableDimension(int length, int width){
        this.width = width;
        this.length = length;
    }
}
