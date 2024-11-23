package Models.Dto.Response;

import Models.ChatBotMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatBotMessageResponseDto {
    private Long id;
    private Date date;
    private String message;
    private boolean isUserMessage;

    public static ChatBotMessageResponseDto fromChatBotMessage(ChatBotMessage chatBotMessage){
        return ChatBotMessageResponseDto.builder()
                .id(chatBotMessage.getChatBotMessageId())
                .date(chatBotMessage.getDate())
                .message(chatBotMessage.getMessage())
                .isUserMessage(chatBotMessage.isUserMessage())
                .build();
    }
}
