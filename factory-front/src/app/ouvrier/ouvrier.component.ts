import { Component, OnInit } from '@angular/core';

import { Ouvrier } from '../common/model/ouvrier.model';
import { OuvrierService } from './ouvrier.service';

@Component({
  selector: 'app-ouvrier',
  templateUrl: './ouvrier.component.html',
  styleUrls: ['./ouvrier.component.css']
})
export class OuvrierComponent implements OnInit {
  ouvriers: Ouvrier[];
  newOuvrier: Ouvrier = new Ouvrier();
  isEditCollapsed: boolean = false;

  constructor(private ouvrierService: OuvrierService) { }

  ngOnInit() {
    this.ouvrierService.getOuvriers()
    .subscribe( data => {
      this.ouvriers = data;
    });
  }

  deleteOuvrier(ouvrier: Ouvrier): void {
    if(confirm("Etes vous sur de supprimer l'ouvrier "+ouvrier.ouvrierNom+" ?")) {
      this.ouvrierService.deleteOuvrier(ouvrier)
      .subscribe( data => {
        this.ouvriers = this.ouvriers.filter(u => u !== ouvrier);
      })
    }
  };

  createOuvrier(): void {
    this.ouvrierService.createOuvrier(this.newOuvrier)
        .subscribe( data => {
          this.ngOnInit();
          this.newOuvrier = new Ouvrier();
          this.isEditCollapsed = false;
        });

  };



}
