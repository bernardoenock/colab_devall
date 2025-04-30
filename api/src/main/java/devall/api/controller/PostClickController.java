package devall.api.controller;

import devall.api.model.Post;
import devall.api.model.PostClick;
import devall.api.repository.PostClickRepository;
import devall.api.repository.PostRepository;
import devall.api.dto.PostClickDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostClickController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostClickRepository postClickRepository;

    @GetMapping("/{id}/click")
    public Map<String, String> registerClick(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));

        post.setClicks(post.getClicks() + 1);
        postRepository.save(post);

        PostClick click = new PostClick();
        click.setPost(post);
        click.setClickDate(LocalDateTime.now());
        postClickRepository.save(click);

        return Map.of("url", post.getUrl());
    }

    @GetMapping("/cliques")
    public List<PostClickDTO> getAllClicks() {
      return postClickRepository.findAll().stream()
        .map(click -> new PostClickDTO(
            click.getPost().getId(),
            click.getPost().getTitle(),
            click.getClickDate()
        ))
        .toList();
    }

    @GetMapping("/cliques/{id}/count")
    public ResponseEntity<Map<String, Long>> getClickCount(@PathVariable Integer id) {
      Post post = postRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Post not found with id " + id));

      Long clickCount = post.getClicks();
      return ResponseEntity.ok(Map.of("clickCount", clickCount));
    }

}
