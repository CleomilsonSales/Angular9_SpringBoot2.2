import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  //responsavel pelas requisições com o back-end
  constructor(private http: HttpClient) {
    
  }

  //o any é pq os metodos da Rest não retorna nada (void)

  //Observable - aplicação reativa
  //requisição assíncrona: ou seja sem o observable não teria uma resposta
  salva(cliente: Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes',cliente);
  }

  atualizar(cliente: Cliente) : Observable<Cliente> {
    return this.http.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`,cliente);
  }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  getClientesById(id: number) : Observable<Cliente> {
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }

  deletar(cliente: Cliente) : Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/clientes/${cliente.id}`);
  }


}
