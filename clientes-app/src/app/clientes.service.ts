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

  //Observable - aplicação reativa
  //requisição assíncrona: ou seja sem o observable não teria uma resposta
  salva(cliente: Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes',cliente);
  }

  getCliente():Cliente {
  let cliente: Cliente = new Cliente();
  cliente.nome = 'Cleomilson Sales';
  cliente.cpf = '12345678912';
  return cliente;
  }
}
