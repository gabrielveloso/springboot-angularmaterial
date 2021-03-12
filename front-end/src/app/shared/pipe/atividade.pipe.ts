import { Pipe, PipeTransform } from '@angular/core';
import { Cargo } from '../model/cargo.model';
import { Elemento } from '../model/elemento.model';

@Pipe({
  name: 'atividade'
})
export class AtividadePipe implements PipeTransform {

  transform(cargos: Cargo[], atividade: Elemento): Cargo[] {
    return cargos.filter(cargo => cargo.atividade.id == atividade.id || (atividade.id == undefined));
  }

}
