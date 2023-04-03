package edu.wpi.teamname.Database.ServiceRequests;

import java.util.ArrayList;

public interface IServiceRequestDAO
{
    public void createRequest(String s, RequestType rt);

    public void updateStatus(String s, Status st);

    public ServiceRequest getSR();

    public ArrayList<ServiceRequest> getAllSRs();




}
