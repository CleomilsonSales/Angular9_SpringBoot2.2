import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { FormsModule } from '@angular/forms';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';


@NgModule({
  declarations: [ClientesFormComponent, ClientesListaComponent],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule //para usar o data-binding - persistencia de dados no angular
  ],
  exports:[
    ClientesFormComponent,
    ClientesListaComponent
  ]
})
export class ClientesModule { }
