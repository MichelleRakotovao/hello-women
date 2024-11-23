package Services;

import Models.Role;
import Models.User;
import Repositories.RoleRepository;
import Repositories.UserRepository;
import io.quarkus.panache.common.Parameters;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RoleService {
    @Inject
    RoleRepository repository;

    public List<Role> getAll(){
        return repository.listAll();
    }

    @Transactional
    public Response createRole(Role newRole) {
        try {
            repository.persist(newRole); // Enregistre l'utilisateur dans la base de donnÃ©es
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            System.out.println("Exception création " + e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


}
