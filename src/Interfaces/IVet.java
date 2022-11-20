package Interfaces;

import Interfaces.IUser;
import Vet.Vet;

import java.io.IOException;

public interface IVet extends IUser {
    String getSpeciality();
    void setSpeciality(String speciality);
    String getDaysAvailable();
    void setDaysAvailable(String daysAvailable);
    // CRUD
    void createVet(String firstName, String lastName, String email, String speciality, String daysAvailable) throws IOException;
    Vet readVet(String email) throws IOException;

    void updateVet(String firstName, String lastName, String email, String speciality, String daysAvailable) throws IOException;
    void deleteVet(String email) throws IOException;

}
