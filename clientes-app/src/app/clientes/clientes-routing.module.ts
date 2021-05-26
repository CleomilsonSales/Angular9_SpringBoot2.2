import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';


const routes: Routes = [
  { path:'clientes', component: LayoutComponent, children:[
    {path: 'form', component: ClientesFormComponent},
    {path: 'form/:id', component: ClientesFormComponent}, //para editar
    {path: 'lista', component: ClientesListaComponent},
    { path: '', redirectTo:'/clientes/lista', pathMatch:'full' } //dessa forma se não informa a rota filha ele carrega um default
  ] }  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
