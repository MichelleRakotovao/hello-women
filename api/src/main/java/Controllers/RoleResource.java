package Controllers;

import Models.Dto.UserDto;
import Models.Role;
import Services.RoleService;
import Services.UserService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/role")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleResource {
    @Inject
    RoleService service;

    @GET
    @Path("/getAll")
    public List<Role> getAll(){
        return service.getAll();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response createMenu(Role newRole){
        try{

            return service.createRole(newRole);
        }
        catch (Exception e){
            System.out.println("Exception création "+e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

}
