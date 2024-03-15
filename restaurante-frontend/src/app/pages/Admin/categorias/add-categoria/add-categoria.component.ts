import { Component } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';

@Component({
  selector: 'app-add-categoria',
  templateUrl: './add-categoria.component.html',
  styleUrls: ['./add-categoria.component.css'],
})
export class AddCategoriaComponent {
  constructor(
    private categoriaService: CategoriaService,
    private messageService: MessageService,
    private formBuilder: FormBuilder,
    private router:Router
  ) {}

  categoriaForm = this.formBuilder.group({
    titulo: ['', Validators.required],
    descripcion: ['', Validators.required],
  });

  formcategoria(){
    console.log(this.categoriaForm.value)
  }

  guardarCategoria(){
    this.categoriaService.addCategoria(this.categoriaForm.value).subscribe(  (res) => {
      console.log(res);
      this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Se ha Agregado La Categoria Correctamente' });
      this.router.navigate(['/admin/view-categoria'])

    },
    (error) => {
      console.error(error);
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error al Guardar Categoria' });
    }
  );
  }

}
