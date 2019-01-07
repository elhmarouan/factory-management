import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  updateMode: boolean = false;
  createForm: FormGroup;
  submitted = false;

  constructor(private tableService: TableService, private formBuilder: FormBuilder) { }

  loadTables() {
    this.tableService.getTables()
      .subscribe(data => {
        this.tables = data;
      });
  }

  ngOnInit() {
    this.createForm = this.formBuilder.group({
      tableNumero: ['', Validators.required]
    });
    this.loadTables();
    this.newTable = new TableUsine();
    this.isEditCollapsed = false;
    this.submitted = false;
    this.updateMode = false;
  }

  // convenience getter for easy access to form fields
  get f() { return this.createForm.controls; }

  deleteTable(table: TableUsine): void {
    if (confirm("Etes vous sur de supprimer la table " + table.tableNumero + " ?")) {
      this.tableService.deleteTable(table)
        .subscribe(data => {
          this.tables = this.tables.filter(u => u !== table);
        })
    }
  };

  createTable(): void {
    this.submitted = true;
    // stop here if form is invalid
    if (this.createForm.invalid) {
      return;
    } else {
      this.tableService.createTable(this.newTable)
        .subscribe(data => {
          this.ngOnInit();
        });
    }
  };

  toggleUpdate(table: TableUsine) {
    if (this.updateMode && table.id === this.newTable.id) {
      this.newTable = new TableUsine();
      this.updateMode = false;
      this.isEditCollapsed = false;
    } else {
      this.newTable = Object.assign({}, table);
      this.isEditCollapsed = true;
      this.updateMode = true;
    }
  }

  cancelUpdate() {
    this.newTable = new TableUsine();
    this.updateMode = false;
    this.isEditCollapsed = false;
  }

}
