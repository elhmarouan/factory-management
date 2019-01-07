import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';


@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  private currentUserUrl = '/api/user';

  public getCurrentUser() {
    return this.http.get<User>(this.currentUserUrl);
  }

}
