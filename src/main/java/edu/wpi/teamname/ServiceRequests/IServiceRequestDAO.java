package edu.wpi.teamname.ServiceRequests;

public interface IServiceRequestDAO
{
    public void createRequest(String s, RequestType rt);

    public void updateStatus(String s, Status st);




}
