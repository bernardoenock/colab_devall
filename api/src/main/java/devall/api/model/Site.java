package devall.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "site")
@Data
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String url;
    private String rss;
    private String about;
    private Boolean iframe;
}