import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  private loginUrl = '/login';
  private logoutUrl= '/logout'

  public login(credentials) {
    return this.http.post<any>(this.loginUrl, credentials);
  }

  public logout() {
    return this.http.get<any>(this.logoutUrl);
  }


}
