import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './views/login/login.component';
import { ConsultarCargosComponent, DialogContentExampleDialog } from './views/consultar-cargos/consultar-cargos.component';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatSelectModule} from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import { UnidadePipe } from './shared/pipe/unidade.pipe';
import { MatDialogModule } from '@angular/material/dialog';
import { NivelPipe } from './shared/pipe/nivel.pipe';
import { AtividadePipe } from './shared/pipe/atividade.pipe';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { FormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { InserirCargoComponent } from './views/inserir-cargo/inserir-cargo.component';
import { HomeComponent } from './views/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { JwtModule } from "@auth0/angular-jwt";
import { STORAGE_KEYS } from 'src/config/storage_keys.config';
import {  AuthInterceptorProvider } from './shared/interceptor/auth.interceptor';


export function tokenGetter() {
  return localStorage.getItem(STORAGE_KEYS.localUser);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ConsultarCargosComponent,
    UnidadePipe,
    DialogContentExampleDialog,
    NivelPipe,
    AtividadePipe,
    InserirCargoComponent,
    HomeComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    FlexLayoutModule,
    MatSelectModule,
    MatTableModule,
    MatDialogModule,
    MatSlideToggleModule,
    FormsModule,
    MatTabsModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        //allowedDomains: ["example.com"],
        //disallowedRoutes: ["http://example.com/examplebadroute/"],
      },
    }),
  ],
  providers: [
    AuthInterceptorProvider
  ],  
  bootstrap: [AppComponent]
})
export class AppModule { }
