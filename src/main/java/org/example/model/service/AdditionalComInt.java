package org.example.model.service;

import org.example.model.entity.Animal;

import java.util.ArrayList;

public interface AdditionalComInt {
    void addAnimalCommand(Animal animal, ArrayList<Animal> animalList, String command);
}
