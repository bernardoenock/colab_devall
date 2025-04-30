package devall.api.dataloader;

import devall.api.model.Post;
import devall.api.model.Site;
import devall.api.repository.PostRepository;
import devall.api.repository.SiteRepository;

import jakarta.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@Profile("!test") 
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {

    private final SiteRepository siteRepository;
    private final PostRepository postRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ResponseEntity<RemotePostDTO[]> resp = restTemplate
            .getForEntity("https://api.devall.com.br/api/v2/post", RemotePostDTO[].class);

        if (resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
            Arrays.stream(resp.getBody()).forEach(this::upsertPost);
        }
    }

    private void upsertPost(RemotePostDTO dto) {
        RemoteSiteDTO s = dto.getSite();
        Site site = siteRepository.findById(s.getId())
          .orElseGet(Site::new);
        site.setName(s.getName());
        site.setUrl(s.getUrl());
        site.setRss(s.getRss());
        site.setAbout(s.getAbout());
        site.setIframe(s.getIframe());
        site = siteRepository.save(site);

        Post post = postRepository.findById(dto.getId())
          .orElseGet(Post::new);
        post.setTitle(dto.getTitle());
        post.setSummary(dto.getSummary());
        post.setUrl(dto.getUrl());
        post.setSite(site);
        post.setIndexDate(dto.getIndexDate());
        post.setPubDate(dto.getPubDate());

        postRepository.save(post);
    }
}