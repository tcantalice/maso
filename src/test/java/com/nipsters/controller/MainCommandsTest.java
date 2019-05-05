package com.nipsters.controller;

import org.junit.Test;

public class MainCommandsTest {

    @Test
    public void getValues(){
        for(MainCommands command : MainCommands.values()){
            System.out.println("MainCommands: " + command);
        }
    }

    @Test
    public void getOrdinal(){
        for(MainCommands command : MainCommands.values()){
            System.out.println("MainCommands Ordinal: " + command.ordinal());
        }
    }

    @Test
    public void getNames() {
        for (MainCommands command : MainCommands.values()) {
            System.out.println("MainCommands Ordinal: " + command.name());
        }
    }
}