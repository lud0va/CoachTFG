import {NgModule} from "@angular/core";
import { AppComponent } from './app.component';
import {BrowserModule} from "@angular/platform-browser";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app.routing.module";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./login-component/login.component";
import {HeaderComponent} from "./shared/header/header.component";
import {FooterComponent} from "./shared/footer/footer.component";
import {NavComponent} from "./shared/nav/nav.component";
import {JwtInterceptorService} from "./services/login/jwt-interceptor.service";
import {ErrorInterceptorService} from "./services/login/error-interceptor.service";

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    NavComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppComponent,
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptorService, multi: true}
  ],
    exports: [
        HeaderComponent,
        FooterComponent,
        NavComponent
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
