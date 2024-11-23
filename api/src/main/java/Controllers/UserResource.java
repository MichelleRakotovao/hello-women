package Controllers;


import Models.Dto.UserDto;
import Models.Role;
import Models.User;
import Services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService service;

    @GET
    @Path("/getAll")
    public List<User> getAll(){
        return service.getAll();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response createUser(UserDto user){
        try{
            return service.createUser(user.getUsername(), user.getPassword(), user.getIdRole());
        }
        catch (Exception e){
            System.out.println("Exception création "+e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDto userDto) {
        return service.login(userDto);
    }
}
