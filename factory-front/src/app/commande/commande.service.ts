import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Commande } from '../common/model/commande.model';
import { Statut } from '../common/model/statut.model';
import { Semaine } from '../common/model/semaine.model';


@Injectable()
export class CommandeService {

    constructor(private http: HttpClient) { }

    private commandeUrl = '/api/commande';
    private statutUrl = '/api/commande/statut';
    private semaineUrl = '/api/commande/semaine';

    public getCommandes() {
        return this.http.get<Commande[]>(this.commandeUrl);
    }

    public getStatuts() {
        return this.http.get<Statut[]>(this.statutUrl);
    }

    public getSemaines() {
        return this.http.get<Semaine[]>(this.semaineUrl);
    }

    public deleteCommande(commande) {
        return this.http.delete(this.commandeUrl + "/" + commande.id);
    }

    public createCommande(commande) {
        return this.http.post<Commande>(this.commandeUrl, commande);
    }
}
