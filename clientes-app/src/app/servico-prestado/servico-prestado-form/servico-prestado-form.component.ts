import { Component, OnInit } from '@angular/core';
import { ServicoPrestadoService } from '../../servico-prestado.service';
import { ClientesService } from '../../clientes.service';
import { Cliente } from '../../clientes/cliente';
import { ServicoPrestado } from '../servicoPrestado';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[] = [];
  sucesso: boolean = false;
  erros: String[];
  servico: ServicoPrestado;

  constructor(
    private clienteService: ClientesService,
    private service: ServicoPrestadoService
  ) { 
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clienteService
      .getClientes()
      .subscribe( response => this.clientes = response );
  }

  onSubmit(){
    this.service
      .salvar(this.servico)
      .subscribe(Response => {
        this.sucesso = true;
        this.erros =  null;
        this.servico =  new ServicoPrestado(); //dessa forma depois de salvar ele limpar o form e esperar novo registro
      }, errorResponse => {
        this.sucesso = false;
        this.erros = errorResponse.error.errors;
      })
  }

}
