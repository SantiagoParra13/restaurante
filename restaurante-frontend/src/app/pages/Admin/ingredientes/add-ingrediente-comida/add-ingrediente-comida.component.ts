import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ComidaService } from 'src/app/service/comida/comida.service';
import { IngredienteService } from 'src/app/service/ingrediente/ingrediente.service';

@Component({
  selector: 'app-add-ingrediente-comida',
  templateUrl: './add-ingrediente-comida.component.html',
  styleUrls: ['./add-ingrediente-comida.component.css'],
})
export class AddIngredienteComidaComponent implements OnInit {
  comidaId: any=null;
  ingredientesComida: any[] = [];
  titulo:any;

  constructor(
    private route: ActivatedRoute,
    private comidaService: ComidaService,
    private ingredienteService: IngredienteService,
    private fb: FormBuilder,
    private messageService: MessageService,
    private router: Router
  ) {  }

    comidaForm = this.fb.group({
    nombre: ['', Validators.required],
    comida: this.fb.group({
      id: [], 
    }),
  });

 ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.comidaId = params.get('id');
      this.titulo=params.get('titulo')
    });
      this.listarIngredientesDelaComida();
      
  }


  agregarIngrediente() {
    // Verifica si comidaForm es nulo o indefinido
    if (this.comidaForm) {
      // Verifica si comidaForm contiene la propiedad 'comida'
      if (this.comidaForm.get('comida')) {
        this.comidaForm.get('comida')?.patchValue({ id: this.comidaId });
      } 
      // Luego, puedes enviar los datos de comidaForm al servicio ingredienteService
      this.ingredienteService.agregarIngrediente(this.comidaForm.value).subscribe(res=>{
        console.log(res)
      });
      this.comidaForm.reset()
    }
  }
  
  listarIngredientesDelaComida(){
    this.ingredienteService.listarIngredientesDeLaComida(this.comidaId).subscribe(res =>{
      this.ingredientesComida = res as any;
    })
  }
  
}
