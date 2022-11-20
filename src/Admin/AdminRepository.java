package Admin;

import Infrastructure.Repository;
import Interfaces.IRepository;

public class AdminRepository extends Repository implements IRepository {

    public AdminRepository() {
        super("src\\Admin\\AdminDataSource.txt");
    }

}
