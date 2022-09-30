import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlluserComponent } from './alluser/alluser.component';
import { CreateComponent } from './create/create.component';
import { LoginComponent } from './login/login.component';
import { MytweetComponent } from './mytweet/mytweet.component';
import { NewTweetComponent } from './new-tweet/new-tweet.component';
import { OnetweetComponent } from './onetweet/onetweet.component';
import { RegisterComponent } from './register/register.component';
import { ReplyComponent } from './reply/reply.component';
import { ResetComponent } from './reset/reset.component';
import { TwitterComponent } from './twitter/twitter.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'twitter', component: TwitterComponent },
  { path: 'twitter/:id', component: TwitterComponent },
  { path: 'create/:id/:userid', component: CreateComponent },
  { path: 'reply/:id/:userid', component: ReplyComponent },
  { path: 'replies/:id/:userid', component: OnetweetComponent },
  { path: 'newTweet/:id', component: NewTweetComponent },
  { path: 'mytweet/:id', component: MytweetComponent },
  { path: 'alluser/:id', component: AlluserComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'reset', component: ResetComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
