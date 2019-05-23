package com.nipsters.controller;

import org.junit.Ignore;
import org.junit.Test;

public class MainCommandsTest {

    @Test
    @Ignore
    public void getValues(){
        for(MainCommands command : MainCommands.values()){
            System.out.println("MainCommands: " + command);
        }
    }

    @Test
    @Ignore
    public void getOrdinal(){
        for(MainCommands command : MainCommands.values()){
            System.out.println("MainCommands Ordinal: " + command.ordinal());
        }
    }

    @Test
    @Ignore
    public void getNames() {
        for (MainCommands command : MainCommands.values()) {
            System.out.println("MainCommands Ordinal: " + command.name());
        }
    }
}