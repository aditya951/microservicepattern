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
  userid1!: string;
  id!: string;
  message: string | undefined;
  company!: Tweet;
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
  addlike(id: string, userId: string, company: Tweet) {
    console.log(`add like clicked ${id}`);
    console.log(`add like clicked ${userId}`);
    this.userid1 = userId;
    this.id = id;
    this.company = company;
    this.sevc
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
  onetweet(id: string) {
    console.log(`repliessss clicked`);
    this.router.navigate(['/replies', id, this.userid]);
  }
  logout() {
    console.log(`logout clicked`);
    this.router.navigate(['login']);
  }
}
