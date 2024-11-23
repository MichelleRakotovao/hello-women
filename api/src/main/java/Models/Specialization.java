package Models;

import javax.persistence.*;

@Entity
@Table(name="specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpecialization",updatable = false)
    private Long idSpecialization;


    @Column(name = "labelSpecialization")
    private String labelSpecialization;

    public Long getIdSpecialization() {
        return idSpecialization;
    }

    public String getLabelSpecialization() {
        return labelSpecialization;
    }

    public void setIdSpecialization(Long idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public void setLabelSpecialization(String labelSpecialization) {
        this.labelSpecialization = labelSpecialization;
    }
}
