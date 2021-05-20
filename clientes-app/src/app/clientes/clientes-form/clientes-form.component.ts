import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  sucesso: boolean = false;
  erros: String[];
  id: number;

  constructor(
    private service: ClientesService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { 

    this.cliente =  new Cliente();

  }

  ngOnInit(): void {
    //pegando o id vindo do parametro
    //duas formas de chamar
    /*let params = this.activatedRoute.params;
    if(params && params['value'] && params['value'].id){
      this.id = params['value'].id;
      this.service
        .getClientesById(this.id)
        .subscribe(
          response => this.cliente = response,
          erroResponse => this.cliente =  new Cliente()
        )
    }*/

    let params : Observable<Params> = this.activatedRoute.params;
    params.subscribe(urlParams =>{
      this.id = urlParams['id'];
      if (this.id){
        this.service
        .getClientesById(this.id)
        .subscribe(
          response => this.cliente = response,
          erroResponse => this.cliente =  new Cliente()
        )
      }
    })
  }

  voltarLista(){
    this.router.navigate(['/clientes-lista']);
  }

  onSubmit(){
    if(this.id){
      this.service
            .atualizar(this.cliente)
            .subscribe(Response => {
              this.sucesso = true;
              this.erros =  null;
            }, errorResponse => {
              this.sucesso = false;
              this.erros = ['Erro ao atualizar cliente.'];
            })
    }else{
      this.service
            .salva(this.cliente)
            .subscribe(Response => {
              this.sucesso = true;
              this.erros =  null;
              this.cliente = Response;
            }, errorResponse => {
              this.sucesso = false;
              this.erros = errorResponse.error.errors;
            })
    }
  }
    
    

}
