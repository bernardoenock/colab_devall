package devall.api.controller;

import devall.api.model.Site;
import devall.api.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sites")
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @PostMapping
    public Site createSite(@RequestBody Site site) {
        return siteRepository.save(site);
    }

    @GetMapping("/{id}")
    public Site getSiteById(@PathVariable Integer id) {
        return siteRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Site updateSite(@PathVariable Integer id, @RequestBody Site siteDetails) {
        Site site = siteRepository.findById(id).orElseThrow();
        site.setName(siteDetails.getName());
        site.setUrl(siteDetails.getUrl());
        site.setRss(siteDetails.getRss());
        site.setAbout(siteDetails.getAbout());
        site.setIframe(siteDetails.getIframe());
        return siteRepository.save(site);
    }

    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable Integer id) {
        siteRepository.deleteById(id);
    }
}