import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cargo } from '../model/cargo.model';
import { Elemento } from '../model/elemento.model';
import { environment } from '../../../environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  
  apiURLBase = "http://localhost:8081/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  public getCargos(): Observable<Cargo[]>{
    return this.httpClient.get<Cargo[]>(`${environment.apiURLBase}/cargo`);
  }

  public deleteCargo(id: number): Observable<Cargo>{
    return this.httpClient.delete<Cargo>(`${environment.apiURLBase}/cargo/`+ id);
  }

  public getUnidades(): Observable<Elemento[]>{
    return this.httpClient.get<Elemento[]>(`${environment.apiURLBase}/unidade`);
  }
  public getNiveis(): Observable<Elemento[]>{
    return this.httpClient.get<Elemento[]>(`${environment.apiURLBase}/nivel`);
  }
  public getAtividades(): Observable<Elemento[]>{
    return this.httpClient.get<Elemento[]>(`${environment.apiURLBase}/atividade`);
  }
  public inserir(cargo: Cargo): Observable<Cargo>{
    return this.httpClient.post<Cargo>(`${environment.apiURLBase}/cargo`, cargo);
  }

  

  public login(email: string, senha: string) {
    console.log(senha);
    return this.httpClient.post<any>(`${environment.apiURLBase}/login`, { email, senha }, {
      observe: 'response'
    });
}
  

}
