package devall.api.controller;

import devall.api.model.Post;
import devall.api.model.Site;
import devall.api.repository.PostRepository;
import devall.api.repository.SiteRepository;
import devall.api.dto.PostDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping
    public List<PostDTO> searchPosts(@RequestParam(required = false) String search) {
        List<Post> posts;
        if (search != null && !search.isEmpty()) {
            posts = postRepository.findByTitleContainingOrSummaryContainingOrderByPubDateDesc(search, search);
        } else {
            posts = postRepository.findAllByOrderByPubDateDesc();
        }

        return posts.stream()
            .map(post -> convertToDTO(post))
            .toList();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        Site site = siteRepository.findById(post.getSite().getId())
                .orElseThrow(() -> new RuntimeException("Site not found with id " + post.getSite().getId()));
        post.setSite(site);
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Integer id) {
        Post post = postRepository.findById(id).orElseThrow();
        return convertToDTO(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow();

        post.setTitle(postDetails.getTitle());
        post.setSummary(postDetails.getSummary());
        post.setUrl(postDetails.getUrl());
        post.setIndexDate(postDetails.getIndexDate());
        post.setPubDate(postDetails.getPubDate());
        post.setClicks(postDetails.getClicks());

        if (postDetails.getSite() != null && !postDetails.getSite().getId().equals(post.getSite().getId())) {
            Site site = siteRepository.findById(postDetails.getSite().getId())
                    .orElseThrow(() -> new RuntimeException("Site not found with id " + postDetails.getSite().getId()));
            post.setSite(site);
        }

        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        postRepository.deleteById(id);
    }

    private PostDTO convertToDTO(Post post) {
        return new PostDTO(
            post.getId(),
            post.getTitle(),
            post.getSummary(),
            post.getUrl(),
            post.getSite().getId(),
            post.getSite().getName()
        );
    }
}
