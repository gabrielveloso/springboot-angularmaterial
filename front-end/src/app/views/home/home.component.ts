import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/shared/service/auth.service';
import { StorageService } from 'src/app/shared/service/storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  email?: string;

  constructor(private storage: StorageService, 
    private authService: AuthService,
    private router: Router) {
    this.email = this.storage.getLocaluser()?.email;  
   }

  ngOnInit(): void {
  }

  logout(){
    this.authService.logout();
    this.router.navigateByUrl("");

  }

}
