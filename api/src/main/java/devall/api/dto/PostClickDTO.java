package devall.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostClickDTO {
    private Integer postId;
    private String postTitle;
    private LocalDateTime clickDate;
}
