package Repositories;

import Models.Consultation;
import Models.Specialization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ConsultationRepository implements PanacheRepository<Consultation> {
}