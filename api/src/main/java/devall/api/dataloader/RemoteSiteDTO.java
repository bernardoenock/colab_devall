package devall.api.dataloader;

import lombok.Data;

@Data
public class RemoteSiteDTO {
    private Integer id;
    private String name;
    private String url;
    private String rss;
    private String about;
    private Boolean iframe;
}