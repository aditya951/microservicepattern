import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TwitterDataService } from '../service/twitter-data.service';
import { Tweet } from '../twitter/twitter.component';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  id!: string;
  userid!: string;
  company!: Tweet;
  turnover: boolean | any;

  constructor(
    private svc: TwitterDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.company = new Tweet(
      'hfghfhfghgf',
      'ghgfhfg',
      'dfdfdf',
      44,
      'hfghfg',
      'gfgdfdsf',
      [],
      []
    );

    this.id = this.route.snapshot.params['id'];

    this.svc.getCompany(this.id).subscribe(
      (data) => {
        this.company = data;
        console.log(this.company);
      },
      (error) => this.handleError(error)
    );
  }

  updateCompany() {
    // if (this.company.companyTurnover < 100000000) {
    //   this.turnover = true;
    // } else {
    this.svc
      .updateCompany(this.id, this.userid, this.company)
      .subscribe((data) => {
        console.log(data);
        this.router.navigate(['twitter']);
      });
    // }
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }
}
