import { Component, OnInit } from '@angular/core';

import { TableUsine } from '../common/model/table-usine.model';
import { TableService } from './table.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  tables: TableUsine[];
  newTable: TableUsine = new TableUsine();
  isEditCollapsed: boolean = false;

  constructor(private tableService: TableService) { }

  ngOnInit() {
    this.tableService.getTables()
    .subscribe( data => {
      this.tables = data;
    });
  }

  deleteTable(table: TableUsine): void {
    if(confirm("Etes vous sur de supprimer la table "+table.tableNumero+" ?")) {
      this.tableService.deleteTable(table)
      .subscribe( data => {
        this.tables = this.tables.filter(u => u !== table);
      })
    }
  };

  createTable(): void {
    this.tableService.createTable(this.newTable)
        .subscribe( data => {
          this.ngOnInit();
          this.newTable = new TableUsine();
          this.isEditCollapsed = false;
        });

  };

}
