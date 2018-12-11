import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { OuvrierComponent } from './ouvrier/ouvrier.component';
import { TableComponent } from './table/table.component';
import { ArticleComponent } from './article/article.component';

const routes: Routes = [
  { path: 'ouvrier', component: OuvrierComponent },
  { path: 'table', component: TableComponent },
  { path: 'article', component: ArticleComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
