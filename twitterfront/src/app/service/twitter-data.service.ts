import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tweet } from '../twitter/twitter.component';
import { Login, User } from '../login/login.component';

@Injectable({
  providedIn: 'root',
})
export class TwitterDataService {
  // string baseurl='vdvfdvf';
  baseurl: string =
    'http://ec2-13-233-117-236.ap-south-1.compute.amazonaws.com:8080';
  // http://localhost:8080'
  // ec2-13-233-117-236.ap-south-1.compute.amazonaws.com
  // http://ec2-13-233-117-236.ap-south-1.compute.amazonaws.com:8080/api/v1.0/tweets/all

  constructor(private http: HttpClient) {}

  retriveAllComapny() {
    return this.http.get<Tweet[]>(this.baseurl + '/api/v1.0/tweets/all');
  }
  //http://localhost:8080/api/v1.0/tweets/users/all
  retriveAlluser() {
    return this.http.get<User[]>(this.baseurl + '/api/v1.0/tweets/users/all');
  }

  // http://localhost:8080/api/v1.0/tweets/users/aditya951
  retriveAllTweetbyuserid(userid: string) {
    console.log(userid);
    return this.http.get<Tweet[]>(this.baseurl + `/api/v1.0/tweets/${userid}`);
  }

  //http://localhost:8080/api/v1.0/tweets/tweet/63220e4c749ee7030506cd7b
  getCompany(id: string) {
    return this.http.get<Tweet>(this.baseurl + `/api/v1.0/tweets/tweet/${id}`);
  }

  //http://localhost:8080/api/v1.0/tweets/999/update/6320b860d23d220d7ffc691f
  //{userId}/update/{id}
  updateCompany(id: string, userid: string, company: Tweet) {
    return this.http.put<Tweet>(
      this.baseurl + `/api/v1.0/tweets/${userid}/update/${id}`,
      company
    );
  }

  //http://localhost:8080/api/v1.0/tweets/876/reply/63220e4c749ee7030506cd7b
  addReply(id: string, userid: string, company: Tweet) {
    return this.http.post<Tweet>(
      this.baseurl + `/api/v1.0/tweets/${userid}/reply/${id}`,
      company
    );
  }
  //http://localhost:8080/api/v1.0/tweets/999/delete/6320b860d23d220d7ffc691f
  deleteCompany(id: string) {
    return this.http.delete(this.baseurl + `/api/v1.0/tweets/delete/${id}`);
  }
  //http://localhost:8080/api/v1.0/tweets/63235a2f0917b87ebf6592ff/add
  addTweet(company: Tweet, id: string) {
    return this.http.post(this.baseurl + `/api/v1.0/tweets/${id}/add`, company);
  }

  //http://localhost:8080/api/v1.0/tweets/register
  register(user: User) {
    return this.http.post(this.baseurl + `/api/v1.0/tweets/register`, user);
  }
  //http://localhost:8080/api/v1.0/tweets/reset
  reset(login: Login) {
    return this.http.post(this.baseurl + `/api/v1.0/tweets/reset`, login);
  }
  //http://localhost:8080/api/v1.0/tweets/login
  login(company: Login) {
    return this.http.post(this.baseurl + `/api/v1.0/tweets/login`, company);
  }
}
