package Services;

import Models.Dto.UserDto;
import Models.Role;
import Models.User;
import Repositories.UserRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.jwt.build.Jwt;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UserService {
    @Inject
    UserRepository repository;

    public List<User> getAll(){
        try{
            return repository.listAll();
        }
        catch (Exception e){
            System.out.println("Exception get "+e);
            return new ArrayList<>();
        }
    }
    public User findByUserName(String userName){
        return repository.find("FROM User r WHERE r.userName = :userName", Parameters.with("userName", userName)).firstResult();
    }
    public Response createUser(String userName, String plainPassword, Integer idRole) {
        try {
            User user = new User();
            // Hasher le mot de passe avec BCrypt
            String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
            user.setPasswordHash(hashedPassword);
            user.setUserName(userName);
            user.setIdRole(idRole);
            user.setDateCreation(new Date());

            repository.persist(user); // Enregistre l'utilisateur dans la base de données

            return Response.status(Response.Status.CREATED).entity(user).build();
        } catch (Exception e) {
            System.out.println("Exception création " + e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


    public String generateToken(User user) {
        if (user.getRole() == null) {
            throw new IllegalStateException("User must have at least one role to generate a token");
        }

        String token =
                Jwt.issuer("http://localhost:8080")
                        .upn(user.getUserName())// user principal name
                        .groups(user.getRole().getRoleName()) // Ajouter tous les rôles au JWT
                        .sign(); // Signe le JWT avec une clé privée configurée dans l'application.properties
        return token;
    }

    public Response login(UserDto userDto){
        // Vérifiez si l'utilisateur existe dans la base de données
        User user = findByUserName(userDto.getUsername());
        //for(User oneUser : users){
        if (user == null) {
            // Si l'utilisateur n'existe pas, renvoyer une réponse Unauthorized
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Inscrivez-vous d'abord")
                    .build();
        }

        // Vérifier que le mot de passe correspond avec le mot de passe haché dans la base de données
        if (!BCrypt.checkpw(userDto.getPassword(), user.getPasswordHash())) {
            // Si les mots de passe ne correspondent pas, renvoyer Unauthorized
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Vérifiez votre mot de passe")
                    .build();
        }


        // Si les identifiants sont corrects, générer un token JWT
        String token = generateToken(user);  // Utiliser l'objet User pour générer le token

        return Response.ok().entity("{\"token\":\"" + token + "\"}").build();
    }
}
