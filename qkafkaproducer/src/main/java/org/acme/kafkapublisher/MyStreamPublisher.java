package org.acme.kafkapublisher;

// import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

@ApplicationScoped
@Path("/")
public class MyStreamPublisher {

    int cnt = 0;

    @Inject @Stream("mystream")
    Emitter<String> emitter;


    @Outgoing("mystream")
    public Flowable<String> generate() {
        return Flowable.interval(1000, TimeUnit.MILLISECONDS)
                .map(msg -> "{\"message\":\"flowing-" + cnt++ +"\"}");
    }

    @GET
    @Path("/10")
    public String send10() {
      
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");
      emitter.send("{\"message\":\"spamming-" + cnt++ +"\"}");

      return "Sent 10";
    }


    @GET
    @Path("/1")
    public String send1() {
      
      emitter.send("{\"message\":\"sending-" + cnt++ +"\"}");
      return "Sent 1";

    }
    
    
}