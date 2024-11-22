package Services;

import Models.Specialization;
import Models.User;
import Repositories.SpecializationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Transactional
public class SpecializationService {
    @Inject
    SpecializationRepository repository;

    public Response createSpecialization(Specialization newSpecialization){
        try {
            repository.persist(newSpecialization);
            return  Response.status(Response.Status.CREATED).build();
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    public List<Specialization> getAll(){
        return repository.listAll();
    }
}
