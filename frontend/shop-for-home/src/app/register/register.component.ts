import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators ,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
//import { Student } from '../student';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registration=this.formBuilder.group({firstname:['',[Validators.required]],
  lastname:['',[Validators.required]],
  username:['',[Validators.required]],
  password:['',[Validators.required]],
  email:['',[Validators.required]],
  phno:['',[Validators.required]],
  address:['',[Validators.required]]
});
  contactForm: any;
  constructor(private formBuilder:FormBuilder,private authenticate:AuthService,private _route:Router) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    
   
    }
  
  
  }
