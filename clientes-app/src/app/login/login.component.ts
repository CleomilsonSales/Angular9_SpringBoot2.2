import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  cadastrando: boolean;
  mensageSuccess: string;
  errors: String[];

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit(){
    this.authService
          .tentarLogar(this.username, this.password)
          .subscribe(response => {
            //guardando o token no localStorage que é um variavel global do navegador
            //assim posso pegar quando eu quiser
            const access_token = JSON.stringify(response); //json em string
            localStorage.setItem('access_token',access_token); 

            this.router.navigate(['/home']);
          },errorResponse => {
            this.errors = ['Usuário e/ou senha inválida!'];
          })
  }

  preparaCadastrar(event){
    event.preventDefault(); //evitar mudar de paginas ao clicar em link
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password =  this.password;
    this.authService
      .salvar(usuario)
      .subscribe( response => {
        this.mensageSuccess = "Cadastro realizado com sucesso! Efetue login";
        this.cadastrando = false;
        this.username = '';
        this.password = '';
        this.errors = [];
      }, errorResponse =>{
        this.mensageSuccess = null;
        this.errors = errorResponse.error.errors;
      })
  }
}
