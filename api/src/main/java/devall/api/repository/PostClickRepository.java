package devall.api.repository;

import devall.api.model.PostClick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostClickRepository extends JpaRepository<PostClick, Integer> {
}