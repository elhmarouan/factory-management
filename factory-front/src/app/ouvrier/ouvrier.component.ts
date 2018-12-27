import { Component, OnInit } from '@angular/core';

import { Ouvrier } from '../common/model/ouvrier.model';
import { OuvrierService } from './ouvrier.service';
import { TableUsine } from '../common/model/table-usine.model';
import { TableService } from '../table/table.service';

@Component({
  selector: 'app-ouvrier',
  templateUrl: './ouvrier.component.html',
  styleUrls: ['./ouvrier.component.css']
})
export class OuvrierComponent implements OnInit {
  ouvriers: Ouvrier[];
  tables: TableUsine[];
  newOuvrier: Ouvrier = new Ouvrier();
  isEditCollapsed: boolean = false;

  constructor(private ouvrierService: OuvrierService, private tableService: TableService) { }

  loadOuvriers() {
    this.ouvrierService.getOuvriers()
    .subscribe( data => {
      this.ouvriers = data;
    });
  }
  ngOnInit() {
    this.loadOuvriers();
    this.tableService.getTables()
    .subscribe( data => {
      this.tables = data;
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
          this.loadOuvriers();
          this.newOuvrier = new Ouvrier();
          this.isEditCollapsed = false;
        });
  };



}
