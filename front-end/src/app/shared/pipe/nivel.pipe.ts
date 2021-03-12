import { Pipe, PipeTransform } from '@angular/core';
import { Cargo } from '../model/cargo.model';
import { Elemento } from '../model/elemento.model';

@Pipe({
  name: 'nivel'
})
export class NivelPipe implements PipeTransform {

  transform(cargos: Cargo[], nivel: Elemento): Cargo[] {
    return cargos.filter(cargo => cargo.nivel.id == nivel.id || (nivel.id == undefined));
  }

}
