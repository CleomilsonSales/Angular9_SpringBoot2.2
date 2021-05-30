import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiURLBase: string = environment.apiURLBase + '/api/clientes';

  //responsavel pelas requisições com o back-end
  constructor(private http: HttpClient) {
    
  }

  //o any é pq os metodos da Rest não retorna nada (void)

  //Observable - aplicação reativa
  //requisição assíncrona: ou seja sem o observable não teria uma resposta
  salva(cliente: Cliente) : Observable<Cliente> {
      return this.http.post<Cliente>(`${this.apiURLBase}`,cliente);
  }

  atualizar(cliente: Cliente) : Observable<Cliente> {    
    return this.http.put<Cliente>(`${this.apiURLBase}/${cliente.id}`,cliente);
  }

  getClientes(): Observable<Cliente[]> {
    /*//pegando o token o OAuth2 sem usar o interceptor
    const token = JSON.parse(localStorage.getItem('access_token'))
    const headers = {
      'Authorization': 'Bearer ' + token.access_token
    }*/
    
    //como a constante em o mesmo nome do headers não precisa do : headers
    return this.http.get<Cliente[]>(`${this.apiURLBase}`/*, { headers }*/);
  }

  getClientesById(id: number) : Observable<Cliente> {

    return this.http.get<any>(`${this.apiURLBase}/${id}`);
  }

  deletar(cliente: Cliente) : Observable<any> {   
    return this.http.delete<any>(`${this.apiURLBase}/${cliente.id}`);
  }


}
