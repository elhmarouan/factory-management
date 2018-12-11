import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Ouvrier } from '../common/model/ouvrier.model';

@Injectable()
export class OuvrierService {

  constructor(private http: HttpClient) { }

  private ouvrierUrl = '/api/ouvrier';

  public getOuvriers() {
      return this.http.get<Ouvrier[]>(this.ouvrierUrl);
  }

  public deleteOuvrier(ouvrier) {
      return this.http.delete(this.ouvrierUrl + "/" + ouvrier.id);
  }

  public createOuvrier(ouvrier) {
      return this.http.post<Ouvrier>(this.ouvrierUrl, ouvrier);
  }

}
