package org.acme.repositories;

import Models.ChatBotMessage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ChatBotMessageRepository implements PanacheRepository<ChatBotMessage> {
    public List<ChatBotMessage> findByAccountIdOrderByDateAsc(Long userId) {
        return find("userId = ?1 order by date asc", userId).list();
    }
}