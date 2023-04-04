package edu.wpi.teamname.Database.Login;

import edu.wpi.teamname.Database.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LoginDAOI {
    public boolean login(String username, String password);

}
