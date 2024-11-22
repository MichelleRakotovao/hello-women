package Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage",updatable = false)
    private Long idMessage;

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idDoctor")
    private Long idDoctor;

    @Column(name = "idConsultation")
    private Long idConsultation;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "created_at")
    private Date createdAt;


    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser",insertable = false,updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor",insertable = false,updatable = false)
    private Doctor doctor;


    @OneToOne
    @JoinColumn(name = "idConsultation", referencedColumnName = "idConsultation",insertable = false,updatable = false)
    private Consultation consultation;

    public Doctor getDoctor() {
        return doctor;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public User getUser() {
        return user;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public String getContenu() {
        return contenu;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }
}
