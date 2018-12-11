package ma.tetouan.factoryrest.repository;

import ma.tetouan.factoryrest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
