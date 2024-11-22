package Controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat")
@ApplicationScoped
public class WebSocketServer {

    private final Map<Session, String> sessionUserMap = new ConcurrentHashMap<>();
    private final Map<String, Session> userSessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        // On peut récupérer un jeton ou autre paramètre pour identifier l'utilisateur
        String userId = session.getRequestParameterMap().get("userId").get(0); // Ex: ?userId=123
        sessionUserMap.put(session, userId);
        userSessionMap.put(userId, session);
        System.out.println("Connected");
    }

    @OnClose
    public void onClose(Session session) {
        String userId = sessionUserMap.remove(session);
        //System.out.println(userId);
        if (userId != null) {
            userSessionMap.remove(userId);
            System.out.println("User disconnected: " + userId);
        }
    }

    @OnMessage
    public void onMessage(String message, Session senderSession) {
        System.out.println("Message received: " + message);

        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();
            String sender = sessionUserMap.get(senderSession);
            String recipient = jsonMessage.getString("recipient");
            String content = jsonMessage.getString("content");

            // Inclure des métadonnées (comme le sender) dans le message envoyé
            JsonObject outgoingMessage = Json.createObjectBuilder()
                    .add("sender", sender) // Remplace "expediteur" par "sender"
                    .add("content", content) // Remplace "destinataire" par "content"
                    .build();

            // Envoyer uniquement au destinataire
            Session recipientSession = userSessionMap.get(recipient);

            if (recipientSession != null && recipientSession.isOpen()) {
                recipientSession.getAsyncRemote().sendText(outgoingMessage.toString());
                System.out.println("Message sent to: " + recipient);
            } else {
                System.out.println("Recipient not found or not connected: " + recipient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
