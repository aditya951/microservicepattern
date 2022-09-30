import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
export class Login {
  constructor(public username: string, public password: string) {}
}

export class User {
  constructor(
    public id: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public contactNo: string,
    public password: string,
    public username: string,
    public profileImage: string
  ) {}
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: Login | any;
  user: User | any;
  error: string = '';
  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.login = new Login('', '');
  }

  logintwitter() {
    console.log(this.login);
    this.svc.login(this.login).subscribe(
      (data) => {
        console.log(data);
        this.user = data;
        console.log(this.user);
        if (this.user.id != null) {
          this.router.navigate(['/twitter', this.user.id]);
        } else {
          alert('wrong username and password');
        }
      },
      (error) => this.handleError(error)
    );
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
    this.error = error.error.message;
  }

  register() {
    this.router.navigate(['/register']);
  }

  reset() {
    console.log('reset clicked');
    this.router.navigate(['reset']);
  }
}
