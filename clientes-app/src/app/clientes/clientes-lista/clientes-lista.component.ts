import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {

  clientes: Cliente[] = []; // iniciado como vázio para evitar erro
  clienteSelecionado: Cliente;
  mensagemSuccess: string;
  mensagemErro: string;

  constructor(
    private service: ClientesService, 
    private router: Router) { }

  ngOnInit(): void {
    this.service
      .getClientes()
      .subscribe(resposta => this.clientes = resposta);
  }

  novoCadastro(){
    this.router.navigate(['/clientes-form']);
  }

  preparaDelecao(cliente: Cliente){
    this.clienteSelecionado = cliente;
  }

  deletarCliente(){
    this.service
      .deletar(this.clienteSelecionado)
      .subscribe(
        response => {
          this.mensagemSuccess = 'Cliente deletado com sucesso!';
          this.ngOnInit();
        },
        erro => this.mensagemErro = 'Ocorreu erro ao deletar cliente!'
      )

  }
}
