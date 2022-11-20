package Infrastructure;

import Client.Client;
import Interfaces.IRepository;
import Interfaces.IUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class Repository implements IRepository {

    private final String path;
    protected static File dataSource;

    protected File connection () {
        DataSource dataSourceOrigin = new DataSource(path);
        return dataSourceOrigin.getDataSource();
    }

    public Repository(String path) {
        this.path = path;
        dataSource = connection();
    }

    public void insert( IUser user) throws IOException {

        BufferedWriter bw;
        String myContent = user.getFirstName() + " & " + user.getLastName() + " & " + user.getEmail();
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

    public ArrayList<IUser> selectAll() throws IOException {
        File dataSource = connection();
        FileReader fr = new FileReader(dataSource);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<IUser> users = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] user = line.split(" & ");
            users.add(new Client(user[0], user[1], user[2]));
        }

        return users;

    }

    public IUser selectByEmail(String email) throws IOException {

        ArrayList<IUser> users = selectAll();
        return users.stream().distinct().filter(v -> v.getEmail().equals(email)).findFirst().orElse(null);

    }

    public void update(String firstName, String lastName, String email) throws IOException {
        IUser user = selectByEmail(email);
        IUser newUser = new Client(firstName, lastName, email);
        Optional<String> fn = Optional.ofNullable(firstName);
        Optional<String> ln = Optional.ofNullable(lastName);

        if (fn.isPresent()) {
            newUser.setFirstName(firstName);
        } else {
            newUser.setFirstName(user.getFirstName());
        }

        if (ln.isPresent()) {
            newUser.setLastName(lastName);
        } else {
            assert user != null;
            newUser.setLastName(user.getLastName());
        }

        delete(email);
        insert(newUser);

        System.out.println("File Updated Successfully");

    }

    public void delete(String email) throws IOException {

        ArrayList<IUser> users = selectAll();
        users.stream().filter(v -> v.getEmail().equals(email)).findFirst().ifPresent(users::remove);
        FileWriter fw = new FileWriter(dataSource);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        for (IUser v : users) {
            insert(v);
        }

    }
}
