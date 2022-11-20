package Vet;

import Infrastructure.DataSource;
import Interfaces.IRepository;
import Interfaces.IUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class VetRepository implements IRepository {



        private static final String path = "src\\Vet\\VetDataSource.txt";
        private static final DataSource dataSourceOrigin = new DataSource(path);
        private static final File dataSource = dataSourceOrigin.getDataSource();


    public VetRepository() {}

    public void insert( Vet vet) throws IOException {

    BufferedWriter bw;
    String myContent = vet.getFirstName() + " & " + vet.getLastName() + " & " + vet.getEmail() + " & " + vet.getSpeciality() + " & " + vet.getDaysAvailable();
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

    public void insert(IUser user) {

    }

    public ArrayList<Vet> selectAll() throws IOException {

        FileReader fr = new FileReader(dataSource);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Vet> vets = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] vet = line.split(" & ");
            vets.add(new Vet(vet[0], vet[1], vet[2], vet[3], vet[4]));
        }

        return vets;

}

    public Vet selectByEmail(String email) throws IOException {
        ArrayList<Vet> vets = selectAll();
        return vets.stream().distinct().filter(v -> v.getEmail().equals(email)).findFirst().orElse(null);

    }

    public void update(String firstName, String lastName, String email) {

    }

    public void update(String firstName, String lastName, String email, String speciality, String daysAvailable) throws IOException {
        Vet vet = selectByEmail(email);
        Vet newVet = new Vet(firstName, lastName, email, speciality, daysAvailable);
        Optional<String> fn = Optional.ofNullable(firstName);
        Optional<String> ln = Optional.ofNullable(lastName);
        Optional<String> sp = Optional.ofNullable(speciality);
        Optional<String> da = Optional.ofNullable(daysAvailable);

        if (fn.isPresent()) {
            newVet.setFirstName(firstName);
        } else {
            newVet.setFirstName(vet.getFirstName());
        }

        if (ln.isPresent()) {
            newVet.setLastName(lastName);
        } else {
            assert vet != null;
            newVet.setLastName(vet.getLastName());
        }

        if (sp.isPresent()) {
            newVet.setSpeciality(speciality);
        } else {
            assert vet != null;
            newVet.setSpeciality(vet.getSpeciality());
        }

        if (da.isPresent()) {
            newVet.setDaysAvailable(daysAvailable);
        } else {
            assert vet != null;
            newVet.setDaysAvailable(vet.getDaysAvailable());
        }

        delete(email);
        insert(newVet);

        System.out.println("File Updated Successfully");

    }

    public void delete(String email) throws IOException {

        ArrayList<Vet> vets = selectAll();
        vets.stream().filter(v -> v.getEmail().equals(email)).findFirst().ifPresent(vets::remove);
        FileWriter fw = new FileWriter(dataSource);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        for (Vet vet : vets) {
            insert(vet);
        }
    }

}
