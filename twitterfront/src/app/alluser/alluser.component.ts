import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../login/login.component';
import { TwitterDataService } from '../service/twitter-data.service';

@Component({
  selector: 'app-alluser',
  templateUrl: './alluser.component.html',
  styleUrls: ['./alluser.component.css'],
})
export class AlluserComponent implements OnInit {
  userid!: string;
  user: User[] = [];
  constructor(
    public sevc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userid = this.route.snapshot.params['id'];
    this.refreshpage();
  }

  refreshpage() {
    this.sevc.retriveAlluser().subscribe(
      (response) => {
        console.log(response);
        this.user = response;
      },
      (error) => this.handleError(error)
    );
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }

  alltweet() {
    console.log(`alltweet cliccked`);
    this.router.navigate(['twitter', this.userid]);
  }
}
