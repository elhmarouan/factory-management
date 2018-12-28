import { Component, OnInit } from '@angular/core';
import { Commande } from '../common/model/commande.model';
import { Article } from '../common/model/article.model';
import { Ouvrier } from '../common/model/ouvrier.model';
import { OuvrierService } from '../ouvrier/ouvrier.service';
import { CommandeService } from '../commande/commande.service';
import { ArticleService } from '../article/article.service';
import { Statut } from '../common/model/statut.model';

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
  isEditCollapsed: boolean = false;
  searchString: string;
  searchStatut: number;

  constructor(private commandeService: CommandeService, private ouvrierService: OuvrierService, private articleService: ArticleService, ) { }

  loadCommands() {
    this.commandeService.getCommandes()
    .subscribe( data => {
      this.commandes = data;
    });
    this.newCommande = new Commande();
    this.newCommande.statut = {id: 0, statutNom: 'Non initié'};
  }

  ngOnInit() {
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
  }

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
    this.commandeService.createCommande(this.newCommande)
        .subscribe( data => {
          this.loadCommands();
          this.isEditCollapsed = false;
        });
  };


}
