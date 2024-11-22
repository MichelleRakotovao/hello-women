package Models;

import javax.persistence.*;
import javax.ws.rs.core.MediaType;

@Entity
@Table(name = "contactsproche")
public class ContactProche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContact",updatable = false)
    private Long idContact;

    @Column(name = "contact")
    private String contact;

    @Column(name = "idUser")
    private Long idUser;

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser",insertable = false,updatable = false)
    private User user;

    public Long getIdUser() {
        return idUser;
    }

    public User getUser() {
        return user;
    }

    public Long getIdContact() {
        return idContact;
    }

    public String getContact() {
        return contact;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }
}