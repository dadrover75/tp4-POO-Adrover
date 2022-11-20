package Interfaces;

import Client.Client;

import java.io.IOException;

public interface IClient extends IUser
{
    void createClient(String firstName, String lastName, String email) throws IOException;
    IUser readClient(String email) throws IOException;
    void updateClient(String firstName, String lastName, String email) throws IOException;
    void deleteClient(String email) throws IOException;

}
