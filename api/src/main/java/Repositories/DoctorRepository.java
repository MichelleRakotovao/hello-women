package Repositories;

import Models.Doctor;
import Models.Specialization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DoctorRepository implements PanacheRepository<Doctor> {
}