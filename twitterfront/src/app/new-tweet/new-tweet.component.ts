import { Component, OnInit } from '@angular/core';
import { Tweet } from '../twitter/twitter.component';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';

@Component({
  selector: 'app-new-tweet',
  templateUrl: './new-tweet.component.html',
  styleUrls: ['./new-tweet.component.css'],
})
export class NewTweetComponent implements OnInit {
  company: Tweet | any;
  turnover: boolean = false;
  error: string = '';
  userid!: string;

  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.company = new Tweet('', '', '', 0, '', '', [], []);

    this.userid = this.route.snapshot.params['id'];
  }

  createCompany() {
    console.log(this.company);
    this.svc.addTweet(this.company, this.userid).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['twitter', this.userid]);
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
