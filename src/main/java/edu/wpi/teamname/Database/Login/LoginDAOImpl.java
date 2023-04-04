package edu.wpi.teamname.Database.Login;

import edu.wpi.teamname.Database.dbConnection;


public class LoginDAOImpl
{
    dbConnection connection;

    HashMap<String, LoginInfo> loginInfo;


    public void establishConnection()
    {
        connection = dbConnection.getInstance();
    }
}