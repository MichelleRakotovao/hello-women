package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatBotMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatBotMessageId;

    private Date date;

    private Long userId;

    @Column(length = 1000)
    private String message;

    private boolean isUserMessage;
}
