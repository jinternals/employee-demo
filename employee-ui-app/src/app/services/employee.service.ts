import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  refresh: EventEmitter<any> = new EventEmitter();

  constructor(private httpClient: HttpClient){}

  public loadAllEmployee(): Observable<Page> {
    return this.httpClient.get<Page>('/api/employee')
  }

  public registerEmployee(employee:Employee): Observable<Page> {
    const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

    return this.httpClient.post<Page>('/api/employee',JSON.stringify(employee),{headers:headers});
  }

  public reloadMainList(){
    return this.refresh
  }

}
