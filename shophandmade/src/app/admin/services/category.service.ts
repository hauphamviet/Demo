import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({
               'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  add(data:any) {
    return this.httpClient.post(this.url + 
      "/danhMucSanPham/them", data, httpOptions)}

  update(id: any, data:any) {
    return this.httpClient.put(this.url +
      "/danhMucSanPham/" + id, data, httpOptions)
  }

  // const headers = new Headers();
  // headers.append('Access-Control-Allow-Headers', 'Content-Type');
  // headers.append('Access-Control-Allow-Methods', 'GET');
  // headers.append('Access-Control-Allow-Origin', '*');


  getDMSP() {
    return this.httpClient.get(this.url+"/danhMucSanPham");
  }

  getFilteredCategory() {
    return this.httpClient.get(this.url + "/danhMucSanPham/get?filterValue=true");
  }

  delete(id: any) {
    return this.httpClient.delete(this.url +"/danhMucSanPham/" +id, {
      headers: new HttpHeaders().set('Content-Type', "application/json")
    })
  }

}
