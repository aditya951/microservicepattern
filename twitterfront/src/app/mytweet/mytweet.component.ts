import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
import { Tweet } from '../twitter/twitter.component';

@Component({
  selector: 'app-mytweet',
  templateUrl: './mytweet.component.html',
  styleUrls: ['./mytweet.component.css'],
})
export class MytweetComponent implements OnInit {
  userid!: string;
  tweets: Tweet[] = [];
  message: string | undefined;
  replies: Tweet[] = [];
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
    this.sevc.retriveAllTweetbyuserid(this.userid).subscribe(
      (response) => {
        console.log(response);
        this.tweets = response;
        this.replies = this.tweets[0].replies;
        console.log('aditya');
        console.log(this.replies);
      },
      (error) => this.handleError(error)
    );
  }
  deleteCompany(id: string) {
    console.log(`delete clicked ${id}`);
    var txt;
    if (confirm('Are u sure, u want to delete!')) {
      this.sevc.deleteCompany(id).subscribe((response) => {
        console.log(response);
        this.message = `delete of company ${id} successful`;
        this.refreshpage();
      });
    } else {
      txt = 'You pressed Cancel!';
    }
  }
  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }

  updateCompany(id: string, userId: string) {
    console.log(`update clicked ${id}`);
    this.router.navigate(['/create', id, userId]);
  }

  alltweet() {
    console.log(`alltweet cliccked`);
    this.router.navigate(['twitter', this.userid]);
  }
}
