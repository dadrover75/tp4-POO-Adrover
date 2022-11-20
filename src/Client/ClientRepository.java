package Client;

import Infrastructure.Repository;
import Interfaces.IRepository;

public class ClientRepository extends Repository implements IRepository {

    public ClientRepository() {
        super("src\\Client\\ClientDataSource.txt");
    }

}
