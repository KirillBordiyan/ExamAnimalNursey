package org.example.model.service;

import org.example.model.entity.*;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class AnimalService implements AdditionalAnimalInt, AdditionalComInt, ShowAnimalInt, ShowComInt{
    @Override
    public void addAnimal(ArrayList<Animal> animalLis) {

        System.out.println("Введите через ', ': имя, дату рождения(ДД.ММ.ГГГГ)");
        try {
            Scanner scanAdd = new Scanner(System.in);
            String animalInfo = scanAdd.nextLine();
            List<String> convertAnimal = Arrays.asList(animalInfo.split(", "));

            if (!convertAnimal.get(1).matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(\\d{4})$")) {
                throw new Exception("неправильная дата");
            }

            System.out.println("К какому типу оно относится:\n" +
                    "1 - собака\n" +
                    "2 - котик\n" +
                    "3 - хомяк\n" +
                    "4 - лошадь\n" +
                    "5 - верблюд\n" +
                    "6 - осел");

            Scanner scanType = new Scanner(System.in);
            int animalType = Integer.parseInt(scanType.next());

            if (animalType < 1 || animalType > 6) {
                throw new RuntimeException("такого вида не существует");
            }

            Animal newAnimal = getAnimal(animalType, convertAnimal);
            animalLis.add(newAnimal);
        }catch (NumberFormatException e){
            System.out.println("это не номер вида питомца");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Animal getAnimal(int animalType, List<String> convertAnimal) {
        Animal newAnimal = null;
        switch (animalType) {
            case 1 -> {
                newAnimal = new Dog(convertAnimal.get(0), "Собака", convertAnimal.get(1));
            }
            case 2 -> {
                newAnimal = new Cat(convertAnimal.get(0), "Кот", convertAnimal.get(1));
            }
            case 3 -> {
                newAnimal = new Hamster(convertAnimal.get(0), "Хомяк", convertAnimal.get(1));
            }
            case 4 -> {
                newAnimal = new Horse(convertAnimal.get(0), "Лошадь", convertAnimal.get(1));
            }
            case 5 -> {
                newAnimal = new Camel(convertAnimal.get(0), "Верблюд", convertAnimal.get(1));
            }
            case 6 -> {
                newAnimal = new Donkey(convertAnimal.get(0), "Осел", convertAnimal.get(1));
            }
        }
        return newAnimal;
    }

    @Override
    public void addAnimalCommand(Animal animal) {
        System.out.println("Введите команды (через запятую, если их несколько): \n");
        Scanner scanCommands = new Scanner(System.in);
        String newCommands = scanCommands.nextLine();
        List<String> commandList = Arrays.asList(newCommands
                .replaceAll("\\s{2,}", " ")
                .split(", "));

        animal.getCommands().addAll(commandList);
    }

    @Override
    public void showAnimals(ArrayList<Animal> animalList) {
        for (Animal animal: animalList) {
            System.out.println(animal);
        }
        System.out.println(" ");
    }

    @Override
    public void showCommands(Animal animal) {
        System.out.println(
                animal.getId() + ", "+
                animal.getName() + ", " +
                "Команды : "
                + String.join(", ", animal.getCommands()));
    }
}
