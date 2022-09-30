import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Login, User } from '../login/login.component';
import { TwitterDataService } from '../service/twitter-data.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css'],
})
export class ResetComponent implements OnInit {
  login: Login | any;
  error: string = '';
  user: User | any;
  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.login = new Login('', '');
  }

  reset() {
    console.log(this.login);
    this.svc.reset(this.login).subscribe(
      (data) => {
        console.log(data);
        this.user = data;
        console.log(this.user);
        if (this.user.id != null) {
          alert('reset success');
          this.router.navigate(['login']);
        } else {
          alert('wrong username');
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
}
