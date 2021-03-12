import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cargo } from 'src/app/shared/model/cargo.model';
import { Elemento } from 'src/app/shared/model/elemento.model';
import { CargoService } from 'src/app/shared/service/cargo.service';

@Component({
  selector: 'app-inserir-cargo',
  templateUrl: './inserir-cargo.component.html',
  styleUrls: ['./inserir-cargo.component.css']
})
export class InserirCargoComponent implements OnInit {

  cargos: Cargo[] = [];
  unidades: Elemento[] = [];
  niveis: Elemento[] = [];
  atividades: Elemento[] = [];
  unidadeSelecionada: Elemento = new Elemento(0, "SELECIONE A UNIDADE");
  nivelSelecionado: Elemento = new Elemento(0, "SELECIONE O NÍVEL");
  atividadeSelecionada: Elemento = new Elemento(0, "SELECIONE A ATIVIDADE");
  
  constructor(public cargoService: CargoService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getCargos();    
    this.getUnidades();
    this.getNiveis();
    this.getAtividades(); 
  }

  getCargos(){
    this.cargoService.getCargos().subscribe(data => {
      this.cargos = data; 
      
    })
  }

  getUnidades(){
    this.cargoService.getUnidades().subscribe(data => {
      this.unidades = data;
    })
  }

  getNiveis(){
    this.cargoService.getNiveis().subscribe(data => {
      this.niveis = data;
    })
  }

  getAtividades(){
    this.cargoService.getAtividades().subscribe(data => {
      this.atividades = data;
    })
  }

  inserir(){
      let cargo: Cargo = {
        id : 0,
        unidade : this.unidadeSelecionada,
        atividade : this.atividadeSelecionada,
        nivel : this.nivelSelecionado
      };    
      
      this.cargoService.inserir(cargo).subscribe( data =>{
            if(data.id > 0){            
                this._snackBar.open("Cargo Inserido", "", {
                  duration: 2000,
                });            
            }
      },(err) => {
        this._snackBar.open("Tente novamente", "", {
          duration: 2000,
        });
        console.log(err)
      });
  }

}
