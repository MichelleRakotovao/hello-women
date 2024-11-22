package Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser",updatable = false)
    private Long idUser;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passwordHash")
    private String passwordHash;

    @Column(name = "idRole")
    private Integer idRole;

    @OneToOne
    @JoinColumn(name = "idRole", referencedColumnName = "idRole",insertable = false,updatable = false)
    private Role role;

    @Column(name = "created_at")
    private Date dateCreation;

    public Long getIdUser() {
        return idUser;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUserName() {
        return userName;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public Role getRole() {
        return role;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
