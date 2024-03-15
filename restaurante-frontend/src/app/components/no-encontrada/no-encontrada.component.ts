import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-no-encontrada',
  templateUrl: './no-encontrada.component.html',
  styleUrls: ['./no-encontrada.component.css']
})
export class NoEncontradaComponent {

  @Input() visible:boolean=false;
  @Input() notFoundMesage:string = 'No encontrada!';
  @Input()ressetLinkText:string = 'Reset';
  @Input() resetLinkRoute:string ='/';
 

}
