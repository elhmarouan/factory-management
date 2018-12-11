package ma.tetouan.factoryrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.tetouan.factoryrest.model.Article;
import ma.tetouan.factoryrest.service.ArticleService;

@RestController
@RequestMapping({"/api/article"})
public class ArticleController {
	
	@Autowired
	ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticle(){
        return articleService.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public Article findArticleById(@PathVariable("id") Integer id){
        return articleService.findById(id);
    }
    
    @PostMapping
    public Article create(@RequestBody Article article){
        return articleService.createArticle(article);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
    }

}
