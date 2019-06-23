package org.acme.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
// import javax.websocket.OnError;
// import javax.websocket.OnMessage;
// import javax.websocket.OnOpen;
// import javax.websocket.Session;
// import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Stream;
import io.smallrye.reactive.messaging.annotations.Emitter;


@ServerEndpoint("/shake")
@ApplicationScoped
public class WebSocket {

    private static final Logger LOG = Logger.getLogger(WebSocket.class);
    private int counter;

    // mystream configured in application.properties    
    
    @Inject @Stream("mystream")
    Emitter<String> emitter;

    @OnOpen
    public void onOpen(Session session) {
        String sessionId = session.getId();
        LOG.info("onOpen: " + sessionId);
        String kafkaMsg = "{\"message\":\"" + "onOpen" + "-" + sessionId + "\"}";
        emitter.send(kafkaMsg);
    }

    @OnClose
    public void onClose(Session session) {
        LOG.info("onClose: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {        
        LOG.error("onError", throwable);        
    }

    @OnMessage
    public void onMessage(String message) {
        String kafkaMsg = "{\"message\":\"" + message + "\"}";
        LOG.info(kafkaMsg);
        emitter.send(kafkaMsg);
    }
}