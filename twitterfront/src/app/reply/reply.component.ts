import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
import { Tweet } from '../twitter/twitter.component';

@Component({
  selector: 'app-reply',
  templateUrl: './reply.component.html',
  styleUrls: ['./reply.component.css'],
})
export class ReplyComponent implements OnInit {
  id!: string;
  userid!: string;
  company!: Tweet;
  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.company = new Tweet('', '', '', 0, '', '', [], []);

    this.id = this.route.snapshot.params['id'];
    this.userid = this.route.snapshot.params['userid'];
  }

  addreply() {
    console.log(this.company);
    this.svc.addReply(this.id, this.userid, this.company).subscribe((data) => {
      console.log(data);
      this.router.navigate(['twitter', this.userid]);
    });
  }
}
