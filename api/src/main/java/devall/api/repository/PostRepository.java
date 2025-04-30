package devall.api.repository;

import devall.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTitleContainingOrSummaryContainingOrderByPubDateDesc(String title, String summary);

    List<Post> findAllByOrderByPubDateDesc();
}