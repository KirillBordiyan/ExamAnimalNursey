package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Animal {
    private int id;
    private String name;
    private String type;
    private String birht;
    private ArrayList<String> commands;

    private int countId;

    Animal(String name, String type, String birht) {
        countId++;
        this.id = countId;
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
