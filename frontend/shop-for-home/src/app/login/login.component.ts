import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators ,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private authenticate:AuthService,private _route:Router) { }
  login=this.formBuilder.group({uname:['',[Validators.required]],
  pass:['',[Validators.required]]});
  submitted = false;
  ngOnInit(): void {
  }
  onSubmit()
  {
    if(this.login.value['uname']=='admin' && this.login.value['pass']=='admin')
    {
      this._route.navigate(['admindashboard']);
    }
    else{
    this.authenticate.loginuser(this.login.value['uname'],this.login.value['pass']).subscribe(
      (response)=>{
       if(response!=null)
       {

        console.log(response.id);
        this._route.navigate(['dashboard',response.id]);
       }
       else{
        alert("Incorrect username password");
       }
      }
    )
  }
  }
  get uname()
  {
    return this.login.get("uname");
  }

  get pass()
  {
    return this.login.get("pass");
  }
}
