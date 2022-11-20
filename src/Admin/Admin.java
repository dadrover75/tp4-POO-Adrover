package Admin;

import Interfaces.IAdmin;
import Infrastructure.Repository;
import Interfaces.IUser;
import User.User;

import java.io.IOException;

public class Admin extends User implements IAdmin {
    // Repository
    public Repository AdminRepository = new AdminRepository();

    public Admin(){};
    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    // CRUD
    public void createAdmin(String firstName, String lastName, String email) throws IOException {
        Admin admin = new Admin(firstName, lastName, email);
        AdminRepository.insert(admin);
    }

    public IUser readAdmin(String email) throws IOException {
        return AdminRepository.selectByEmail(email);
    }

    public void updateAdmin(String firstName, String lastName, String email) throws IOException {
        AdminRepository.update(firstName, lastName, email);
    }

    public void deleteAdmin(String email) throws IOException {
        AdminRepository.delete(email);
    }

}

