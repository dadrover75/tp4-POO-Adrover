package Appointment;

import Interfaces.IAppointment;

import java.io.IOException;
import java.util.ArrayList;

public class Appointment implements IAppointment {

    private String date;
    private Service service;
    private String client;
    private String vet;

    // Constructor

    public Appointment() {}

    public Appointment(String date, String service, String clientEmail, String vetEmail) {
        this.date = date;
        this.service = service.equals("GROOMING") ? Service.GROOMING : service.equals("VACCINATION") ? Service.VACCINATION : Service.CLINIC;
        this.client = clientEmail;
        this.vet = vetEmail;
    }

    // Getters and Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    // CRUD

    public void createAppointment(String date, String service, String clientEmail, String vetEmail) throws IOException {
        Appointment appointment = new Appointment(date, service, clientEmail, vetEmail);
        AppointmentRepository.insert(appointment);
    }

    public ArrayList<Appointment> readClientAppointment(String clientEmail) throws IOException {
        return AppointmentRepository.selectByClientEmail(clientEmail);
    }

    public ArrayList<Appointment> readVetAppointment(String vetEmail) throws IOException {
        return AppointmentRepository.selectByVetEmail(vetEmail);
    }

    // TODO migrate to DB implementation with PK elegible for update and delete
//    public static void updateAppointment(String date, String service, String clientEmail, String vetEmail) throws IOException {
//        AppointmentRepository.update(date, service, clientEmail, vetEmail);
//    }
//
//    public static void deleteAppointment(String clientEmail) throws IOException {
//        AppointmentRepository.delete(clientEmail);
//    }

}

