import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/shared/service/auth.service';
import { CargoService } from 'src/app/shared/service/cargo.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public form!: FormGroup;
  

  constructor(private fb: FormBuilder,
     private cargoService: CargoService,
      private router: Router,
      private authService: AuthService) {
    
   }

  ngOnInit(): void {
    this.form = this.fb.group({      
      email: ['', [Validators.email, Validators.required]],      
      senha: ['', Validators.required]      
    });

    this.form.valueChanges.subscribe(data=>{
      
    })
  }

  submit(): void {
    this.authService.login(this.form.value.email, this.form.value.senha).subscribe(
      dados => {
        this.authService.sucessfullLogin(dados.headers.get("Authorization"));
        console.log(dados.headers.get("Authorization"));
        console.log("User is logged in");
        this.router.navigateByUrl('/cargos');
      },
      error => { console.log("user or pass invalid")}
    );
  }

}
