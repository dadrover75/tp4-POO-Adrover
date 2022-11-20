package Client;

import Interfaces.IClient;
import Infrastructure.Repository;
import Interfaces.IUser;
import User.User;
import java.io.IOException;

public class Client extends User implements IClient {
    // Repository
    Repository ClientRepository = new ClientRepository();
    // Constructor
    public Client(){};
    public Client(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
    // Getters and Setters
    // CRUD
    public void createClient(String firstName, String lastName, String email) throws IOException {
        Client client = new Client(firstName, lastName, email);
        ClientRepository.insert(client);
    }

    public IUser readClient(String email) throws IOException {
        return ClientRepository.selectByEmail(email);
    }

    public void updateClient(String firstName, String lastName, String email) throws IOException {
        ClientRepository.update(firstName, lastName, email);
    }

    public void deleteClient(String email) throws IOException {
        ClientRepository.delete(email);
    }

}
