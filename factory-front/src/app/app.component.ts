import { Component } from '@angular/core';
import { User } from './common/model/user.model';
import { AuthService } from './common/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  navbarCollapsed = true;
  currentUser: User;

  constructor(private authService: AuthService) { }

  loadCurrentUser() {
    this.authService.getCurrentUser()
    .subscribe(data => {
      console.info(data);
      this.currentUser = data;
      console.info(this.currentUser);
    });
  }

  ngOnInit() {
    this.loadCurrentUser();
  }
}
