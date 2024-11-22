/*package Models;

import javax.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctor",updatable = false)
    private Long idDoctor;

    @Column(name = "name")
    private String name;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "idspecialization")
    private Long idSpecialization;

    @Column(name = "idUser")
    private Long idUser;

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser",insertable = false,updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "idspecialization", referencedColumnName = "idspecialization",insertable = false,updatable = false)
    private Specialization specialization;

    public Long getIdSpecialization() {
        return idSpecialization;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public Long getIdUser() {
        return idUser;
    }

    public User getUser() {
        return user;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setIdSpecialization(Long idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
*/