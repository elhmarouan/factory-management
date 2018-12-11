import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { TableUsine } from '../common/model/table-usine.model';

@Injectable()
export class TableService {

  constructor(private http: HttpClient) { }

  private tableUrl = '/api/table';

  public getTables() {
      return this.http.get<TableUsine[]>(this.tableUrl);
  }

  public deleteTable(table) {
      return this.http.delete(this.tableUrl + "/" + table.id);
  }

  public createTable(table) {
      return this.http.post<TableUsine>(this.tableUrl, table);
  }

}
