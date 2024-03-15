import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';
import { ComidaService } from 'src/app/service/comida/comida.service';

@Component({
  selector: 'app-add-comida',
  templateUrl: './add-comida.component.html',
  styleUrls: ['./add-comida.component.css']
})
export class AddComidaComponent implements OnInit {

constructor( private fb: FormBuilder,
  private categoriaService: CategoriaService,
  private comidaService:ComidaService,
  private messageService: MessageService,
  private router:Router){}

  categorias:any[]=[];



  comidaForm=this.fb.group({
    nombre:['',Validators.required],
    descripcion:['',Validators.required],
    price:['',Validators.required],
    stars:['',Validators.required],
    categoria: ({
      categoriaId: ['']
    }),
    image:['']
  })

  ngOnInit(): void {
    this.categoriaService.listarCategorias().subscribe((res)=>{
      console.log(res)
      this.categorias = res as any[];
    })
  }

  guardarComidas(){
    console.log(this.comidaForm.value)
  }

    // Método para enviar la comida al servidor
    guardarComida() {

        this.comidaService.addComida(this.comidaForm.value).subscribe(
          (res) => {
            this.messageService.add({
              severity: 'success',
              summary: 'Success',
              detail: 'Comida Guardada Con Exito',
            });
            this.comidaForm.reset();
            setTimeout(() => {
              this.router.navigate(['/admin/view-comidas']);
            }, 2000);
          },
          (error) => {
            console.error(error);
            this.messageService.add({
              severity: 'error',
              summary: 'Error',
              detail: 'Error al Guardar Comida',
            });
          }
        );
    }

  onFileChange(event: any) {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = (e) => {
      const base64String = reader.result as string;
      this.comidaForm.controls['image'].setValue(base64String);
    };

    reader.readAsDataURL(file);
  }


}
