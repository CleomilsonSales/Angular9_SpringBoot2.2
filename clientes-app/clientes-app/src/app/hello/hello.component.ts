import { Component } from '@angular/core'

@Component({
    selector: 'hello',
    templateUrl: './hello.component.html'
})

//export é como um public no java
export class HelloComponent{ 

    texto: string;
    clientes: Cliente[];

    constructor(){
        this.texto = 'Estudos Angular 9';

        //let é uma variavel local
        //cont é uma constante
        let cliente1 = new Cliente('Cleomilson', 38);
        let cliente2 = new Cliente('Saori', 4);
        let cliente3 = new Cliente('Rita Miranda', 42);

        this.clientes = [cliente1, cliente2, cliente3];
    }

}

class Cliente{

    constructor(
        public nome: string,
        public idade: number
    ){ }

}