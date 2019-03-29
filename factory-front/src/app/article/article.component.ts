import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  createForm: FormGroup;
  submitted = false;
  updateMode = false;

  constructor(private articleService: ArticleService, private formBuilder: FormBuilder) { }

  loadArticles() {
    this.articleService.getArticles()
    .subscribe( data => {
      this.articles = data;
    });
  }
  ngOnInit() {
    this.createForm = this.formBuilder.group({
      articleNumero: ['', Validators.required],
      nbHeures: ['']
    });
    this.loadArticles();
    this.newArticle = new Article();
    this.isEditCollapsed = false;
    this.submitted = false;
    this.updateMode = false;
  }

  // convenience getter for easy access to form fields
  get f() { return this.createForm.controls; }  

  deleteArticle(article: Article): void {
    if(confirm("Etes vous sur de supprimer l'article "+article.articleNumero+" ?")) {
      this.articleService.deleteArticle(article)
      .subscribe( data => {
        this.articles = this.articles.filter(u => u !== article);
      })
    }
  };

  createArticle(): void {
    this.submitted = true;
    // stop here if form is invalid
    if (this.createForm.invalid) {
      return;
    } else {
      this.articleService.createArticle(this.newArticle)
      .subscribe( data => {
        this.ngOnInit();
      });
    }
  };

  toggleUpdate(article: Article) {
    if (this.updateMode && article.id === this.newArticle.id) {
      this.newArticle = new Article();
      this.updateMode = false;
      this.isEditCollapsed = false;
    } else {
      this.newArticle = Object.assign({}, article);
      this.isEditCollapsed = true;
      this.updateMode = true;
    }
  }

  cancelUpdate() {
    this.newArticle = new Article();
    this.updateMode = false;
    this.isEditCollapsed = false;
  }

}
