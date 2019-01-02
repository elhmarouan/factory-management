import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgHttpLoaderModule } from 'ng-http-loader';
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
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomErrorHandler } from './common/custom-error-handler';

@NgModule({
  declarations: [
    AppComponent,
    OuvrierComponent,
    TableComponent,
    ArticleComponent,
    CommandeComponent,
    FilterPipe,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgHttpLoaderModule.forRoot(),
    FormsModule,
    AngularFontAwesomeModule,
    ReactiveFormsModule.withConfig({ warnOnNgModelWithFormControl: 'never' }),
    NgbModule.forRoot()
  ],
  providers: [OuvrierService, TableService, ArticleService, CommandeService, {
    provide: ErrorHandler,
    useClass: CustomErrorHandler,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
