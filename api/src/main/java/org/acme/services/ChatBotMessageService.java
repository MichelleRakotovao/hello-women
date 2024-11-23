package org.acme.services;

import Models.ChatBotMessage;
import Models.Dto.Response.ChatBotMessageResponseDto;
import java.util.List;

public interface ChatBotMessageService {
    List<ChatBotMessageResponseDto> getMessagesByUserId(Long userId);
    ChatBotMessageResponseDto saveMessage(ChatBotMessage message);

}
