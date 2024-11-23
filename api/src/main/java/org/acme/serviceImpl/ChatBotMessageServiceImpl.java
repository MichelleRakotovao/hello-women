package org.acme.serviceImpl;

import Models.ChatBotMessage;
import Models.Dto.Response.ChatBotMessageResponseDto;
import org.acme.repositories.ChatBotMessageRepository;
import org.acme.services.ChatBotMessageService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ChatBotMessageServiceImpl implements ChatBotMessageService {
    public final ChatBotMessageRepository chatBotMessageRepository;
    @Inject
    public ChatBotMessageServiceImpl(ChatBotMessageRepository chatBotMessageRepository) {
        this.chatBotMessageRepository = chatBotMessageRepository;
    }
    @Override
    public List<ChatBotMessageResponseDto> getMessagesByUserId(Long userId) {
        List<ChatBotMessage> messages = chatBotMessageRepository.findByAccountIdOrderByDateAsc(userId);
        return messages.stream()
                .map(ChatBotMessageResponseDto::fromChatBotMessage)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public ChatBotMessageResponseDto saveMessage(ChatBotMessage message) {
        message.setDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        chatBotMessageRepository.persist(message);
        return ChatBotMessageResponseDto.fromChatBotMessage(message);
    }

}

