import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { LocalUser } from '../model/local_user';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  

  constructor(private httpClient: HttpClient,
    public storage : StorageService,
    public jwtHelper: JwtHelperService) { }


  public login(email: string, senha: string) {
    console.log(senha);
    return this.httpClient.post<any>(`${environment.apiURLBase}/login`, { email, senha }, {
      observe: 'response'
    });
  }

  sucessfullLogin(authorizationValue: string | null){
    let tok = ""
    if(authorizationValue){
      tok = authorizationValue.substring(7);
    }

    console.log(this.jwtHelper.decodeToken(tok));

    let user: LocalUser = {
      token: tok,
      email: this.jwtHelper.decodeToken(tok).sub
    }

    this.storage.setLocaluser(user);
  }

  logout(){
    this.storage.setLocaluser(null);
  }
}
