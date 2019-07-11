package com.robot;

import lombok.Data;

@Data
public class Robot {

    private Position position;

    public CommandStatus place(Position position){
        this.position = position;
    }

    public CommandStatus move(){
        Direction direction = position.getDirection();
    }

    public CommandStatus left(){

    }

    public CommandStatus right(){

    }

    public void report(){

    }
}
