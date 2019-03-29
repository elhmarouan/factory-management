import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Commande } from '../common/model/commande.model';
import { Article } from '../common/model/article.model';
import { Ouvrier } from '../common/model/ouvrier.model';
import { OuvrierService } from '../ouvrier/ouvrier.service';
import { CommandeService } from '../commande/commande.service';
import { ArticleService } from '../article/article.service';
import { Statut } from '../common/model/statut.model';
import { Semaine } from '../common/model/semaine.model';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {
  commandes: Commande[];
  newCommande: Commande;
  articles: Article[];
  ouvriers: Ouvrier[];
  statuts: Statut[];
  semaines: Semaine[];
  isEditCollapsed: boolean = false;
  searchString: string;
  searchStatut: number;
  searchSemaine: number;
  createForm: FormGroup;
  submitted = false;
  updateMode = false;

  constructor(private commandeService: CommandeService, private ouvrierService: OuvrierService, private articleService: ArticleService, private formBuilder: FormBuilder) { }

  loadCommands() {
    this.commandeService.getCommandes()
    .subscribe( data => {
      this.commandes = data;
    });
    this.newCommande = new Commande();
    this.newCommande.statut = {id: 0, statutNom: 'Non initié'};
    this.newCommande.ouvrier = new Ouvrier();
    this.newCommande.article = new Article();
    this.newCommande.semaine = new Semaine();
  }

  ngOnInit() {
    this.createForm = this.formBuilder.group({
      commandNumber: ['', Validators.required],
      article: ['', Validators.required],
      ouvrier: ['', Validators.required],
      statut: ['', Validators.required],
      semaine: ['', Validators.required],
      nbHeures: ['']
    });
    this.loadCommands();
    this.ouvrierService.getOuvriers()
    .subscribe( data => {
      this.ouvriers = data;
    });
    this.articleService.getArticles()
    .subscribe( data => {
      this.articles = data;
    });
    this.commandeService.getStatuts()
    .subscribe( data => {
      this.statuts = data;
    });
    this.commandeService.getSemaines()
    .subscribe( data => {
      this.semaines = data;
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.createForm.controls; }

  onStatutChange(event, commande): void {
    this.commandeService.createCommande(commande)
    .subscribe( data => {
      // this.loadCommands();
      alert("Le statut de la commande "+commande.commandeNumero+" a été modifié.");
    });
  }

  deleteCommande(commande: Commande): void {
    if(confirm("Etes vous sur de supprimer la commande "+commande.commandeNumero+" ?")) {
      this.commandeService.deleteCommande(commande)
      .subscribe( data => {
        this.commandes = this.commandes.filter(u => u !== commande);
      })
    }
  };

  createCommande(): void {
    this.submitted = true;
    // stop here if form is invalid
    if (this.createForm.invalid) {
      return;
    } else {
      this.commandeService.createCommande(this.newCommande)
      .subscribe( data => {
        this.loadCommands();
        this.createForm = this.formBuilder.group({
          commandNumber: ['', Validators.required],
          article: ['', Validators.required],
          ouvrier: ['', Validators.required],
          statut: ['', Validators.required],
          semaine: ['', Validators.required]
        });
        this.submitted = false;
        this.isEditCollapsed = false;
        this.updateMode = false;
      });
    }
  };

  toggleUpdate(commande: Commande) {
    if (this.updateMode && commande.id === this.newCommande.id) {
      this.newCommande = new Commande();
      this.newCommande.statut = {id: 0, statutNom: 'Non initié'};
      this.newCommande.ouvrier = new Ouvrier();
      this.newCommande.article = new Article();
      this.newCommande.semaine = new Semaine();
      this.updateMode = false;
      this.isEditCollapsed = false;
    } else {
      this.newCommande = Object.assign({}, commande);
      this.isEditCollapsed = true;
      this.updateMode = true;
    }
  }

  cancelUpdate() {
    this.newCommande = new Commande();
    this.newCommande.statut = {id: 0, statutNom: 'Non initié'};
    this.newCommande.ouvrier = new Ouvrier();
    this.newCommande.article = new Article();
    this.newCommande.semaine = new Semaine();
    this.updateMode = false;
    this.isEditCollapsed = false;
  }

  calculRendement(commande: Commande, article: Article) {
    if (commande.nbHeures && article.nbHeures) {
      return (article.nbHeures * 100 / commande.nbHeures ) + ' %';
    }
  }

}
