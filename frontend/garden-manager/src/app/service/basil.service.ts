import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BasilService {
  public API     = '//localhost:8080';
  public BASIL_API = this.API + '/basil';

  constructor(private http: HttpClient) { }

  getName(name: string){
    return this.http.get(this.API + '/basil/name')
  }
}
