package Interfaces;

import Appointment.Appointment;
import Appointment.Service;

import java.io.IOException;
import java.util.ArrayList;

public interface IAppointment
{
    String getDate();
    void setDate(String date);
    Service getService();
    void setService(Service service);
    String getClient();
    void setClient(String client);
    String getVet();
    void setVet(String vet);
    // CRUD
    void createAppointment(String date, String service, String clientEmail, String vetEmail) throws IOException;
    ArrayList<Appointment> readClientAppointment(String clientEmail) throws IOException;
    ArrayList<Appointment> readVetAppointment(String vetEmail) throws IOException;
}
