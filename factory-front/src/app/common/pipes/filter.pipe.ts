import { Pipe, PipeTransform, Injectable } from '@angular/core';

@Pipe({
  name: 'filter'
})

@Injectable()
export class FilterPipe implements PipeTransform {

  transform(items: any[], statut: number, semaine: number, value: string): any[] {
    if (!items) {
      return [];
    }

    let filteredItems: any[] = items;

    if (!value && !statut && !semaine) {
      return items;
    }

    if (value) {
      filteredItems = items.filter(singleItem =>
        singleItem.commandeNumero.toLowerCase().includes(value.toLowerCase()) ||
        singleItem.article.articleNumero.toLowerCase().includes(value.toLowerCase()) ||
        (singleItem.ouvrier.ouvrierNom + '' + singleItem.ouvrier.ouvrierPrenom).toLowerCase().includes(value.toLowerCase())
      );
    }

    if (statut) {
      filteredItems = filteredItems.filter(singleItem =>
        singleItem.statut.id == statut);
    }

    if (semaine) {
      filteredItems = filteredItems.filter(singleItem =>
        singleItem.semaine.id == semaine);
    }

    return filteredItems;
  }

}
