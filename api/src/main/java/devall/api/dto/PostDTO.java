package devall.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDTO {
    private Integer id;
    private String title;
    private String summary;
    private String url;
    private Integer siteId;
    private String siteName;
}