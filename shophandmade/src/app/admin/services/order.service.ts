import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  getOrder() {
    return this.httpClient.get(this.url +"/donHang")
  }

  updateStatus(id:any, data:any) {
    return this.httpClient.put(this.url +
      "/donHang/" +id, data, {
        headers: new HttpHeaders().set('Content-Type', "application/json")
      })
  }


}
