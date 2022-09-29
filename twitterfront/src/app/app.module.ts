import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TwitterComponent } from './twitter/twitter.component';
import { CreateComponent } from './create/create.component';
import { ReplyComponent } from './reply/reply.component';
import { NewTweetComponent } from './new-tweet/new-tweet.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MytweetComponent } from './mytweet/mytweet.component';
import { AlluserComponent } from './alluser/alluser.component';

@NgModule({
  declarations: [AppComponent, TwitterComponent, CreateComponent, ReplyComponent, NewTweetComponent, LoginComponent, RegisterComponent, MytweetComponent, AlluserComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
