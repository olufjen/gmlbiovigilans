package no.naks.biovigilans.web.server.resource;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

public class Tracer extends Restlet {


    public Tracer(Context context) {
        super(context);
    }
    public Tracer(){
    	super();
    }
    

    @Override
    public void handle(Request request, Response response) {
        String entity = "Method       : " + request.getMethod()
                + "\nResource URI : " 
                + request.getResourceRef()
                + "\nIP address   : " 
                + request.getClientInfo().getAddress()
                + "\nAgent name   : " 
                + request.getClientInfo().getAgentName()
                + "\nAgent version: "
                + request.getClientInfo().getAgentVersion();
        response.setEntity(entity, MediaType.TEXT_PLAIN);
    }
}
