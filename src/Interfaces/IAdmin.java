package Interfaces;

import Admin.Admin;

import java.io.IOException;

public interface IAdmin
{
    void createAdmin(String firstName, String lastName, String email) throws IOException;
    IUser readAdmin(String email) throws IOException;
    void updateAdmin(String firstName, String lastName, String email) throws IOException;
    void deleteAdmin(String email) throws IOException;
}
