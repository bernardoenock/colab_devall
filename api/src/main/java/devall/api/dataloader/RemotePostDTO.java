package devall.api.dataloader;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RemotePostDTO {
    private Integer id;
    private String title;
    private String summary;
    private String url;
    private RemoteSiteDTO site;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime indexDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pubDate;
}
