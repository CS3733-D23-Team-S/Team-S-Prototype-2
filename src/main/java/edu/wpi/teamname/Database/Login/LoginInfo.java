package edu.wpi.teamname.Database.Login;

public class LoginInfo
{
    private String username;
    private String password;
    private Permission permissionLevel;

    public LoginInfo(String username, String password, Permission permissionLevel)
    {
        this.username = username;
        this.password = password;
        this.permissionLevel = permissionLevel;
    }



}
