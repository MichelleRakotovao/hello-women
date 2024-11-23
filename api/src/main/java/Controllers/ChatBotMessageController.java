package Controllers;

import Models.ChatBotMessage;
import Models.Dto.Response.ChatBotMessageResponseDto;
import org.acme.services.ChatBotMessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/chatbot/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChatBotMessageController {
    @Inject
    ChatBotMessageService chatBotMessageService;
    @GET
    @Path("/{userd}")
    public List<ChatBotMessageResponseDto> getMessagesByAccountId(@PathParam("accountId") Long userId) {
        return chatBotMessageService.getMessagesByUserId(userId);
    }
    @POST
    public Response saveMessage(ChatBotMessage message) {
        ChatBotMessageResponseDto savedMessage = chatBotMessageService.saveMessage(message);
        return Response.ok(savedMessage).build();
    }
}

