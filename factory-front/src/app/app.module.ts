import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OuvrierComponent } from './ouvrier/ouvrier.component';
import { OuvrierService } from './ouvrier/ouvrier.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TableComponent } from './table/table.component';
import { TableService } from './table/table.service';
import { ArticleComponent } from './article/article.component';
import { ArticleService } from './article/article.service';
import { CommandeComponent } from './commande/commande.component';
import { CommandeService } from './commande/commande.service';
import { FilterPipe } from './common/pipes/filter.pipe';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

@NgModule({
  declarations: [
    AppComponent,
    OuvrierComponent,
    TableComponent,
    ArticleComponent,
    CommandeComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    NgbModule.forRoot()
  ],
  providers: [OuvrierService, TableService, ArticleService, CommandeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
