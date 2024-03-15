import { Component, OnInit } from '@angular/core';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';

@Component({
  selector: 'app-view-categoria',
  templateUrl: './view-categoria.component.html',
  styleUrls: ['./view-categoria.component.css']
})
export class ViewCategoriaComponent implements OnInit {
  categorias: any = [];


  constructor(private categoriaService:CategoriaService,){}
  ngOnInit(): void {
    this.categoriaService.listarCategorias().subscribe(res=>{
      this.categorias = res;
    })
  }

}
