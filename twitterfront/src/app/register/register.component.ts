import { Component, OnInit } from '@angular/core';
import { User } from '../login/login.component';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  user: User | any;
  error: string = '';

  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.user = new User('', '', '', '', '', '', '', '');
  }

  register() {
    console.log(this.user);
    this.svc.register(this.user).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['login']);
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
}
