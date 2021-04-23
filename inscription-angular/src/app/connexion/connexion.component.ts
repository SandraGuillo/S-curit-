import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Password, PasswordDTO} from "./password.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class ConnexionComponent implements OnInit {
  public _pass: PasswordDTO;

  public _passwords: Password[];
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this._pass = new PasswordDTO();
    this.getAllPass();
  }

  private getPasshttp() :Observable<any> {
    return this.http.get('http://localhost:8080/password');
  }
  getAllPass(){
    this.getPasshttp().subscribe((pass)=>{
      this._passwords = pass;
    })
  }

  signIn(){
    console.log(this._pass.sel);
    console.log(this._pass.password);
    // let headers = new HttpHeaders().set('access-control-allow-origin',"http://localhost:8080/password");
//    this.httpHeader.set('access-control-allow-origin',"http://localhost:8080/");
    this.http.post('http://localhost:8080/password',this._pass).subscribe(()=>{},
      (error => {console.log(error)}));
    this.getAllPass();
  }

}
