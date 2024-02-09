package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class Counter {
    public int animalCount = 0;
    public void increment(){
        animalCount++;
    }

    public void showAllCount(){
        System.out.println("Всего питомцев: " + animalCount + "\n");
    }
}
