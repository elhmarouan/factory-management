import { Ouvrier } from './ouvrier.model';
import { Article } from './article.model';
import { Statut } from './statut.model';
import { Semaine } from './semaine.model';

export class Commande {
    id: number;
    commandeNumero: string;
    article: Article;
    ouvrier: Ouvrier;
    statut: Statut;
    semaine: Semaine;
    nbHeures: number;
}