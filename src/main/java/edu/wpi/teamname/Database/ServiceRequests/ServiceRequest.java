package edu.wpi.teamname.Database.ServiceRequests;

import java.security.Provider;

public class ServiceRequest
{
    public RequestType requestType;
    public Status  status;
    public String asignee;
    public ServiceRequest(RequestType rt, Status s, String a)
    {
        requestType = rt;
        status = s;
        asignee = a;
    }
}
