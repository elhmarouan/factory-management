package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.Article;
import ma.tetouan.factoryrest.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;
	
	public List<Article> findAll() {
		return articleRepository.findAll();
	}
	
	public Article createArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public void deleteArticle(Integer articleId) {
		Article article = articleRepository.findById(articleId).orElse(null);
		if (article != null) {
			articleRepository.delete(article);
		}
	}
	
	public Article findById(Integer articleId) {
		return articleRepository.findById(articleId).orElse(null);
	}

}
