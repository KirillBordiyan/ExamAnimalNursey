package org.example.controller;

import org.example.model.entity.Animal;
import org.example.model.service.AnimalService;
//import org.example.view.AnimalNurseyView;

import java.util.ArrayList;
import java.util.Scanner;


public class AnimalNurseyController {

    ArrayList<Animal> animalList;
//    AnimalNurseyView view;
    AnimalService service;

    public AnimalNurseyController() {
        this.animalList = new ArrayList<>();
        this.service = new AnimalService();
    }

    public void run(){
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите действие по номеру:\n" +
                    "1 - добавить нового питомца в реестр\n" +
                    "2 - посмотреть список всех питомцев\n" +
                    "3 - вывести команды питомца\n" +
                    "4 - добавить новую команду питомцу\n" +
                    "5 - завершить работу");

            Scanner startScan = new Scanner(System.in);
            int firstInput = Integer.parseInt(startScan.next());

            switch (firstInput) {
                case 1 -> {
                    AnimalService addAnimalService = new AnimalService();
                    addAnimalService.addAnimal(animalList);
                }
                //todo сделать норм версию с логической цепочкой

                case 2 -> service.showAnimals(animalList);
               /* case 3 -> {
                    System.out.println("Выберите номер питомца: \n");
                    view.showAnimalService.showAnimals(animalList);
                    Scanner scanPointThree = new Scanner(System.in);
                    int animalId = Integer.parseInt(scanPointThree.next());
                    view.showComService.showCommands(animalList.get(animalId));
                }*/
                case 5 -> flag = false;
            }
        }


    }


}
