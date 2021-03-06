import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const tokenString = localStorage.getItem('access_token');
    
    const url = request.url; 

    //verificando se não esta vazio no localStorange
    if(tokenString && !url.endsWith(environment.obterTokenUrl)){
      const token = JSON.parse(tokenString);
      const jwt = token.access_token;
      request = request.clone({
        setHeaders : {
          Authorization: 'Bearer ' + jwt
        } 
      })
    }
    
    
    return next.handle(request);
  }
}
