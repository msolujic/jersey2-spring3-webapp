package no.osthus.rest;

import no.osthus.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class MyResource {

    private final MyService service;

    public MyResource(MyService service) {
        this.service = service;
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!" + service.toString();
    }

    @Path("error")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getError() {
        throw new IllegalArgumentException("Error!");
    }
}
