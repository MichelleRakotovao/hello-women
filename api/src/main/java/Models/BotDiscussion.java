package Models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class BotDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long botDiscussionId;

    @OneToMany
    private List<BotMessage> messages;

    private Date createdAt;


}
