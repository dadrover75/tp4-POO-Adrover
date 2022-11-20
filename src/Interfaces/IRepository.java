package Interfaces;

import java.io.*;
import java.util.ArrayList;

public interface IRepository {

    void insert(IUser user) throws IOException;
    ArrayList<?> selectAll() throws IOException;
    IUser selectByEmail(String email) throws IOException;
    void update(String firstName, String lastName, String email) throws IOException;
    void delete(String email) throws IOException;
}
