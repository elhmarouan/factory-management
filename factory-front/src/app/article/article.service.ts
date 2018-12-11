import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Article } from '../common/model/article.model';

@Injectable()
export class ArticleService {

  constructor(private http: HttpClient) { }

  private articleUrl = '/api/article';

  public getArticles() {
      return this.http.get<Article[]>(this.articleUrl);
  }

  public deleteArticle(article) {
      return this.http.delete(this.articleUrl + "/" + article.id);
  }

  public createArticle(article) {
      return this.http.post<Article>(this.articleUrl, article);
  }

}
