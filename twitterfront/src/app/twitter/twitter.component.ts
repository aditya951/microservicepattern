import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';

export class Tweet {
  constructor(
    public id: string,
    public userId: string,
    public name: string,
    public likes: number,
    public localDateTimeCreated: string,
    public message: string,
    public tag: string[],
    public replies: Tweet[] // public List<Stock> stocks=new ArrayList<>();
  ) {}
}

@Component({
  selector: 'app-twitter',
  templateUrl: './twitter.component.html',
  styleUrls: ['./twitter.component.css'],
})
export class TwitterComponent implements OnInit {
  tweets: Tweet[] = [];
  userid!: string;
  message: string | undefined;
  constructor(
    public sevc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.refreshpage();
    this.userid = this.route.snapshot.params['id'];
  }

  refreshpage() {
    this.sevc.retriveAllComapny().subscribe(
      (response) => {
        console.log(response);
        this.tweets = response;
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

  reply(id: string, userId: string) {
    console.log(`add stock clicked ${id}`);
    this.router.navigate(['/reply', id, userId]);
  }

  createoneCompany() {
    console.log(`create clicked`);

    this.router.navigate(['newTweet', this.userid]);
  }

  mytweet() {
    console.log(`mytweet clicked`);
    this.router.navigate(['mytweet', this.userid]);
  }

  alluser() {
    console.log(`alluser clicked`);
    this.router.navigate(['alluser', this.userid]);
  }
}
