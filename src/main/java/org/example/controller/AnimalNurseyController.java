package org.example.controller;

import org.example.model.entity.Animal;
import org.example.model.service.AnimalService;
//import org.example.view.AnimalNurseyView;

import java.util.ArrayList;
import java.util.Scanner;


public class AnimalNurseyController {

    ArrayList<Animal> animalList;
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
            int firstInput = Integer.parseInt(startScan.nextLine());

            switch (firstInput) {
                case 1 -> {
                    AnimalService addAnimalService = new AnimalService();
                    addAnimalService.addAnimal(animalList);
                }
                case 2 -> service.showAnimals(animalList);
                case 3 -> {
                    System.out.println("Выберите номер питомца: \n");
                    service.showAnimals(animalList);
                    Scanner scanPointThree = new Scanner(System.in);
                    int animalId = Integer.parseInt(scanPointThree.next());

                    service.showCommands(animalList.get(animalId-1));
                }
                case 4 -> {
                    System.out.println("Выберите номер питомца: \n");
                    service.showAnimals(animalList);
                    Scanner scanPointFour = new Scanner(System.in);
                    int animalId = Integer.parseInt(scanPointFour.next());

                    service.addAnimalCommand(animalList.get(animalId-1));
                }
                case 5 -> {
                    System.out.println("Все-го хоро-шего!");
                    flag = false;
                    startScan.close();
                }
            }
        }
    }
}
