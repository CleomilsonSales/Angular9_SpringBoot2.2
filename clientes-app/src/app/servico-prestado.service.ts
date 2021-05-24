import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServicoPrestado } from './servico-prestado/servicoPrestado';
import { environment } from '../environments/environment';
import { ServicoPrestadoBusca } from './servico-prestado/servico-prestado-lista/servicoPrestadoBusca';

@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {

  apiURLBase: string = environment.apiURLBase + '/api/servicos-prestados';

  constructor(private http: HttpClient) { }

  salvar(servicoPrestado: ServicoPrestado): Observable<ServicoPrestado>{
    return this.http.post<ServicoPrestado>(this.apiURLBase, servicoPrestado);
  }

  buscar(nome: string, mes: number) : Observable<ServicoPrestadoBusca[]> {
    const httpParams =  new HttpParams()
      .set("nome", nome ? nome : '')
      .set("mes", mes ? mes.toString() : '');

    const url = this.apiURLBase + "?" + httpParams.toString();//lembrando que const é uma constante
    //a url ficara= localhost:8080/api/servicos-prestados?nome=Mazinha&mes=2
    return this.http.get<any>(url);
  }
}
