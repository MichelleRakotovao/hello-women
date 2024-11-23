package Repositories;

import Models.Specialization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SpecializationRepository implements PanacheRepository<Specialization> {
}