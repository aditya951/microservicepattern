import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
import { Tweet } from '../twitter/twitter.component';

@Component({
  selector: 'app-onetweet',
  templateUrl: './onetweet.component.html',
  styleUrls: ['./onetweet.component.css'],
})
export class OnetweetComponent implements OnInit {
  id!: string;
  userid!: string;
  userid1!: string;

  company!: Tweet;
  turnover: boolean | any;
  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userid = this.route.snapshot.params['userid'];

    this.svc.getCompany(this.id).subscribe(
      (data) => {
        this.company = data;
        console.log(this.company);
        // this.router.navigate(['twitter', this.userid]);
      },
      (error) => this.handleError(error)
    );
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }
  addlike(id: string, userId: string, company: Tweet) {
    console.log(`add like clicked ${id}`);
    console.log(`add like clicked ${userId}`);
    this.userid1 = userId;
    this.id = id;
    this.company = company;
    this.svc
      .updateCompany(this.id, this.userid, this.company)
      .subscribe((data) => {
        console.log(data);
        // this.router.navigate(['/twitter', this.userid]);
        this.router.navigate(['mytweet', this.userid]);
      });
  }
  reply(id: string, userId: string) {
    console.log(`add stock clicked ${id}`);

    this.router.navigate(['/reply', id, this.userid]);
  }

  alltweet() {
    console.log(`alltweet cliccked`);
    this.router.navigate(['twitter', this.userid]);
  }
}
