import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  signup(data:any) {
    return this.httpClient.post(this.url+
      "/users/signup", data, {
        headers: new HttpHeaders().set('Content-Type', 'application/json')
      })
  }

  login(data:any) {
    return this.httpClient.post(this.url+
      "/users/login", data, {
        headers: new HttpHeaders().set('Content-Type', 'application/json')
      })
  }

  checkToken() {
    return this.httpClient.get(this.url+"/users/checkToken");
  }

  getUsers() {
    return this.httpClient.get(this.url+"/users");
  }

  update(id: any, data:any) {
    return this.httpClient.put(this.url+
      "/users/update/" +id, data, {
        headers:new HttpHeaders().set('Content-Type', "application/json")
      })
  }

}
