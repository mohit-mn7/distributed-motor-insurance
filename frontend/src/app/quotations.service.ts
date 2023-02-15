import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuotationsService {

  POST_CLIENT_DATA_URL = 'http://localhost:8080/user';
  QUOTES_URL = 'http://localhost:8080/quotes';
  
  constructor(private httpClient: HttpClient) { }

  postClientInformation(clientData: any){
    return this.httpClient.post(this.POST_CLIENT_DATA_URL, clientData);
  }

  getQuotationsForCurrentClient(clientData: any){
    return this.httpClient.post(this.QUOTES_URL, clientData);
  }
}
