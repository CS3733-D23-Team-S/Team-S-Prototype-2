package edu.wpi.teamname.Database.Login;

import edu.wpi.teamname.Database.dbConnection;


public class loginDAOImpl
{
    dbConnection connection;


    public void establishConnection()
    {
        connection = dbConnection.getInstance();
    }
}