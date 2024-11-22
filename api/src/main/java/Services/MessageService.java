package Services;

import Models.Message;
import Models.Specialization;
import Repositories.MessageRepository;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class MessageService {
    @Inject
    MessageRepository repository;

    public Response createMessage(Message newMsg){
        try {
            repository.persist(newMsg);
            return  Response.status(Response.Status.CREATED).build();
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    public List<Message> getAll(){
        return repository.listAll();
    }

}
