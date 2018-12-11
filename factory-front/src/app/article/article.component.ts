import { Component, OnInit } from '@angular/core';

import { Article } from '../common/model/article.model';
import { ArticleService } from './article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articles: Article[];
  newArticle: Article;
  isEditCollapsed: boolean = false;

  constructor(private articleService: ArticleService) { }

  ngOnInit() {
    this.articleService.getArticles()
    .subscribe( data => {
      this.articles = data;
    });
    this.newArticle = new Article();
  }

  deleteArticle(article: Article): void {
    if(confirm("Etes vous sur de supprimer l'article "+article.articleNumero+" ?")) {
      this.articleService.deleteArticle(article)
      .subscribe( data => {
        this.articles = this.articles.filter(u => u !== article);
      })
    }
  };

  createArticle(): void {
    this.articleService.createArticle(this.newArticle)
        .subscribe( data => {
          this.ngOnInit();
          this.isEditCollapsed = false;
        });

  };

}
