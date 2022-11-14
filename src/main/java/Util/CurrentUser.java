package Util;

import Entities.Dog;

import java.util.List;

public class CurrentUser {
    private static int currentId;
    private static String userName;
    private static int numberAdopted;
    private static List<Dog> dogs;

    public CurrentUser() {
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        CurrentUser.currentId = currentId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        CurrentUser.userName = userName;
    }

    public static int getNumberAdopted() {
        return numberAdopted;
    }

    public static void setNumberAdopted(int numberAdopted) {
        CurrentUser.numberAdopted = numberAdopted;
    }

    public static List<Dog> getDogs() {
        return dogs;
    }

    public static void setDogs(List<Dog> dogs) {
        CurrentUser.dogs = dogs;
    }
}
