package org.acme.repositories;

import Models.BotMessage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BotMessageRepository implements PanacheRepository<BotMessage> {
}
