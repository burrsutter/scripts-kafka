package com.burrsutter.qkk;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloResource {

    boolean goslow = false;

    @GET  
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/slow")
    @Produces(MediaType.TEXT_PLAIN)
    public String slow() {
        goslow = true;
        return "slowing down";
    }

    @GET
    @Path("/fast")
    @Produces(MediaType.TEXT_PLAIN)
    public String fast() {
        goslow = false;
        return "Normal speed";
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public String eventGreet(String inputJson) {
      System.out.println("Received: " + inputJson);
      if (goslow) {
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
          System.err.println(e);
        }
      }
      return "OK";
    }
  
}