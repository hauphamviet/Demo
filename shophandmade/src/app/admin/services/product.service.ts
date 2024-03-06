import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  add(data:any) {
    return this.httpClient.post(this.url +
      "/sanPham/them", data, {
        headers:new HttpHeaders().set('Content-Type', "application/json")
      })
  }

  update(id: any, data:any) {
    return this.httpClient.put(this.url +
      "/sanPham/" +id, data, {
        headers:new HttpHeaders().set('Content-Type', "application/json")
      })
  }

  getProduct() {
    return this.httpClient.get(this.url +"/sanPham")
  }

  updateStatus(id:any, data:any) {
    return this.httpClient.put(this.url +
      "/sanPham/trangThai/" +id, data, {
        headers:new HttpHeaders().set('Content-Type', "application/json")
      })
  }

  delete(id:any) {
    return this.httpClient.delete(this.url +"/sanPham/" +id, {
      headers: new HttpHeaders().set('Content-Type', "application/json")
    })
  }

  getProducsByCategory(id:any) {
    return this.httpClient.get(this.url+"/sanPham/"+id);
  }

  getById(id:any) {
    return this.httpClient.get(this.url+"/sanPham/"+id);
  }

}
