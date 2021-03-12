import { Pipe, PipeTransform } from '@angular/core';
import { Cargo } from '../model/cargo.model';
import { Elemento } from '../model/elemento.model';

@Pipe({
  name: 'unidade'
})
export class UnidadePipe implements PipeTransform {

  transform(cargos: Cargo[], unidade: Elemento): Cargo[] {
    return cargos.filter(cargo => cargo.unidade.id == unidade.id || (unidade.id == undefined));
  }

}
