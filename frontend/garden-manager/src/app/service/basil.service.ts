import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
  }
)
export class BasilService {

  public API = 'http://localhost:8080';
  public BASIL_API = this.API + '/basil';

  constructor(private http: HttpClient) { }

  getName(): Observable<string>{
    return this.http.get<string>(this.API + '/basil/name');
  }

  temperature(): Observable<number>{
    return this.http.get<number>(this.BASIL_API + '/basil/temp')
  }
}
