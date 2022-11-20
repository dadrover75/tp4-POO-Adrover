package Appointment;

import Infrastructure.DataSource;

import java.io.*;
import java.util.ArrayList;

public class AppointmentRepository {

    // conexion con la base de datos
    private static final DataSource dataSourceOrigin = new DataSource("src\\Appointment\\AppointmentDataSource.txt");
    private static final File dataSource = dataSourceOrigin.getDataSource();
    // INSERT App INTO AppDataSource
    public static void insert(Appointment appointment) throws IOException {

    BufferedWriter bw;
    String myContent = appointment.getDate() + " & " + appointment.getService().toString() + " & " + appointment.getClient() + " & " + appointment.getVet();
    FileReader fr = new FileReader(dataSource);
    BufferedReader br = new BufferedReader(fr);


    if (br.readLine() == null) {

        bw = new BufferedWriter(new FileWriter(dataSource, true));
        bw.append(myContent);
        bw.newLine();
        bw.flush();

        System.out.println("File Written Successfully");

    } else {

        bw = new BufferedWriter(new FileWriter(dataSource, true));
        bw.append(myContent);
        bw.newLine();
        bw.flush();

        System.out.println("File Appended Successfully");

    }

    }
    // SELECT * FROM AdminDataSource
    public static ArrayList<Appointment> selectAll() throws IOException {

        FileReader fr = new FileReader(dataSource);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Appointment> appointments = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] appointment = line.split(" & ");
            appointments.add(new Appointment(appointment[0], appointment[1], appointment[2], appointment[3]));
        }
        return appointments;

}
    // SELECT * FROM AppointmentDataSource WHERE email = email
    public static ArrayList<Appointment> selectByClientEmail(String email) throws IOException {

        ArrayList<Appointment> appts = selectAll();
        ArrayList<Appointment> apptsByClient = new ArrayList<>();
        for (Appointment appt : appts ) {
            if (appt.getClient().equals(email)) {
                apptsByClient.add(appt);
            }
        }

        return apptsByClient;

    }
    // SELECT * FROM AppointmentDataSource WHERE email = email
    public static ArrayList<Appointment> selectByVetEmail(String email) throws IOException {

        ArrayList<Appointment> appts = selectAll();
        ArrayList<Appointment> apptsByVet = new ArrayList<>();
        for (Appointment appt : appts ) {
            if (appt.getVet().equals(email)) {
                apptsByVet.add(appt);
            }
        }

        return apptsByVet;

    }
    // TODO migrate to DB implementation with PK elegible for update and delete
//    // UPDATE AdminDataSource SET firstName = firstName, lastName = lastName, email = email WHERE email = email
//    public static void update(String date, String service, String clientEmail, String vetEmail) throws IOException {
//        Appointment appt = selectByEmail(email);
//        Appointment newAppt = new Appointment(firstName, lastName, email);
//        Optional<String> fn = Optional.ofNullable(firstName);
//        Optional<String> ln = Optional.ofNullable(lastName);
//
//
//        if (fn.isPresent()) {
//            newAppt.setFirstName(firstName);
//        } else {
//            newAppt.setFirstName(admin.getFirstName());
//        }
//
//        if (ln.isPresent()) {
//            newAppt.setLastName(lastName);
//        } else {
//            assert admin != null;
//            newAppt.setLastName(admin.getLastName());
//        }
//
//
//        delete(email);
//        insert(newAppt);
//
//        System.out.println("File Updated Successfully");
//
//    }
//    // DELETE FROM AdminDataSource WHERE email = email
//    public static void delete(String email) throws IOException {
//
//        ArrayList<Appointment> admin = selectAll();
//        admin.stream().filter(a -> a.getEmail().equals(email)).findFirst().ifPresent(admin::remove);
//
//        for (Appointment a : admin) {
//            insert(a);
//        }
//
//    }

}
