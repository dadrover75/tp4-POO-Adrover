package Vet;

import java.io.IOException;

import Interfaces.IVet;
import User.User;

public class Vet extends User implements IVet {
    // Repository
    public VetRepository VetRepository = new VetRepository();

    private String speciality;

    private String daysAvailable;
    // Constructor
    public Vet(){}

    public Vet(String firstName, String lastName, String email, String speciality, String daysAvailable) {
        super(firstName, lastName, email);
        this.speciality = speciality;
        this.daysAvailable = daysAvailable;
    }
    // Getters and Setters
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(String daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
    // CRUD
    public void createVet(String firstName, String lastName, String email, String speciality, String daysAvailable) throws IOException {
        Vet vet = new Vet(firstName, lastName, email, speciality, daysAvailable);
        VetRepository.insert(vet);
    }

    public Vet readVet(String email) throws IOException {
        return VetRepository.selectByEmail(email);
    }

    public void updateVet(String firstName, String lastName, String email, String speciality, String daysAvailable) throws IOException {
        VetRepository.update(firstName, lastName, email, speciality, daysAvailable);
    }

    public void deleteVet(String email) throws IOException {
        VetRepository.delete(email);
    }

}

