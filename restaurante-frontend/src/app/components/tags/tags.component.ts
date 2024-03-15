import { Component, Input, OnInit } from '@angular/core';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {
  @Input()
  foodPageTags?:string[];

  @Input()
  justifyContent?:string='center';


  tags?:any[]=[];

  constructor(private categoriaService:CategoriaService){}


  ngOnInit(): void {
    if(!this.foodPageTags){
      this.categoriaService.listarCategorias().subscribe(res =>{
        this.tags=res as any;
      })
    }
  }

}
