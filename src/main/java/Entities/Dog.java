package Entities;

import Enums.DogGender;

public class Dog {
    private int id;
    private String name;
    private int age;
    private DogGender gender;
    private String dogBreed;
    private boolean vaccinated;
    private boolean adopted;

    public Dog() {
    }

    public Dog(String name, int age, DogGender gender, String dogBreed, boolean vaccinated, boolean adopted) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dogBreed = dogBreed;
        this.vaccinated = vaccinated;
        this.adopted = adopted;
    }

    public Dog(int id, String name, int age, DogGender gender, String dogBreed, boolean vaccinated, boolean adopted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dogBreed = dogBreed;
        this.vaccinated = vaccinated;
        this.adopted = adopted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DogGender getGender() {
        return gender;
    }

    public void setGender(DogGender gender) {
        this.gender = gender;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", dogBreed='" + dogBreed + '\'' +
                ", vaccinated=" + vaccinated +
                ", adopted=" + adopted +
                '}';
    }
}
