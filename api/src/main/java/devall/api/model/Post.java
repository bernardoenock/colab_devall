package devall.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String summary;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    @Column(name = "index_date")
    private LocalDateTime indexDate;

    @Column(name = "pub_date")
    private LocalDateTime pubDate;

    private Long clicks = 0L;
}