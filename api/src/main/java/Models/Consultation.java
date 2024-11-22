package Models;

import javax.persistence.*;

@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsultation",updatable = false)
    private Long idConsultation;

    @Column(name = "anonyme")
    private Boolean anonyme;

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idDoctor")
    private Long idDoctor;

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser",insertable = false,updatable = false)
    private User user;


    @OneToOne
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor",insertable = false,updatable = false)
    private Doctor doctor;

    public Long getIdDoctor() {
        return idDoctor;
    }

    public Long getIdUser() {
        return idUser;
    }

    public User getUser() {
        return user;
    }

    public Boolean getAnonyme() {
        return anonyme;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnonyme(Boolean anonyme) {
        this.anonyme = anonyme;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
