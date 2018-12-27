import { Ouvrier } from './ouvrier.model';
import { Article } from './article.model';
import { Statut } from './statut.model';

export class Commande {
    id: number;
    commandeNumero: string;
    article: Article;
    ouvrier: Ouvrier;
    statut: Statut;
}