import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DialogService } from 'primeng/dynamicdialog';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';
import { ComidaService } from 'src/app/service/comida/comida.service';
import { LoginService } from 'src/app/service/usuario/login/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  foods: any;
  comidaFiltrada: any;
  logeado: any;
  categoriaId: any;
  parametros =false;

  constructor(
    private food: ComidaService,
    private categoriaService: CategoriaService,
    private route: ActivatedRoute
  ) {}

  mostrarImagen = false;
  imagenEspecifica = 'assets/food2.png';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      if (params['categoryId']) {
        const categoryId = params['categoryId'];
          this.parametros=true;
        // Llama a tu servicio para cargar las comidas de la categoría específica
        this.loadComidasPorCategoria(categoryId);
      } else {
        // Lógica para cargar todas las comidas si no se proporciona un parámetro de categoría
        this.food.recomendada().subscribe((res) => {
          this.foods = res;
          // Resto de la lógica...
        });
      }

      if (params['item']) {
        this.parametros=true;
        this.filterFoods(params['item']);
        console.log(this.filterFoods(params['item']));
      } else {
        this.comidaFiltrada = this.foods; // Mostrar todas las comidas si no hay un término de búsqueda
      }
    });
  }

  filterFoods(searchTerm: string) {
    if (this.foods) {
      this.comidaFiltrada = this.foods.filter((food: any) =>
        food.nombre.toLowerCase().includes(searchTerm.toLowerCase())
      );
    }
  }

  // Método para cargar comidas por categoría
  loadComidasPorCategoria(categoryId: string) {
    this.categoriaService.listarComidaDeUnaCategoria(categoryId).subscribe((res) => {
      this.comidaFiltrada = res;
      console.log(this.comidaFiltrada)
      // Resto de la lógica para mostrar las comidas filtradas por categoría...
    });
  }
}
