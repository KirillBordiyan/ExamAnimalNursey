package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Animal {
    private int id;
    private String name;
    private String type;
    private String birht;
    private ArrayList<String> commands;

    public static int counter = 0;

    Animal(String name, String type, String birht) {
        counter++;
        this.id = counter;
        this.name = name;
        this.type = type;
        this.birht = birht;
        this.commands = new ArrayList<>();

    }

    @Override
    public String toString() {
        return getId() +", "
                + getName() +", "
                + getType() +", "
                + getBirht();
    }
}
