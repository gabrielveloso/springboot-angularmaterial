import { Component, OnInit } from '@angular/core';
import { Cargo } from 'src/app/shared/model/cargo.model';
import { Elemento } from 'src/app/shared/model/elemento.model';
import { CargoService } from 'src/app/shared/service/cargo.service';
import {MatDialog} from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-consultar-cargos',
  templateUrl: './consultar-cargos.component.html',
  styleUrls: ['./consultar-cargos.component.css']
})



export class ConsultarCargosComponent implements OnInit {

  selecionado: boolean = true;
  cargos: Cargo[];
  unidades: Elemento[] = [];
  niveis: Elemento[] = [];
  atividades: Elemento[] = [];
  unidadeSelecionada: Elemento = new Elemento(0, "SELECIONE A UNIDADE");
  nivelSelecionado: Elemento = new Elemento(0, "SELECIONE O NÍVEL");
  atividadeSelecionada: Elemento = new Elemento(0, "SELECIONE A ATIVIDADE");
  displayedColumns: string[] = ["unidade", "nivel", "atividade","ocupado", "deletar"]
  dataSet: CargoElement[] = [];
  dataSet2: Cargo[] = [];

  constructor(public cargoService : CargoService, public dialog: MatDialog, private _snackBar: MatSnackBar) {     
    this.cargos = [];
    this.getCargos();    
    this.getUnidades();
    this.getNiveis();
    this.getAtividades();    
  }

  ngOnInit(): void {
    this.getCargos();    
  }

  openDialog(id:number) {    
    const dialogRef = this.dialog.open(DialogContentExampleDialog);
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if(result){
        console.log(id);
        this.cargoService.deleteCargo(id).subscribe(data=>{
          this.getCargos();
          if(data.id = id){
              this._snackBar.open("Cargo deletado", "", {
                duration: 2000,
              }); 
          }

          
        });
      }
    });
  }

  getCargos(){
    this.cargoService.getCargos().subscribe(data => {
      this.cargos = data;    

      let dataTemp: CargoElement[] = [];
      this.cargos.forEach((dado: Cargo) => {
        dataTemp.push({
          unidade: dado.unidade.nome,
          nivel: dado.nivel.nome,
          atividade: dado.atividade.nome
        });  
      });     
      
      this.dataSet = dataTemp;
      console.log(this.dataSet);
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
}
 
interface CargoElement {
  unidade: string;
  nivel: string;
  atividade: string;
}

@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: './dialog-content-example-dialog.html',
})
export class DialogContentExampleDialog {}

