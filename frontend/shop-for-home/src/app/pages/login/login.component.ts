import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Role } from "../../enum/Role";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  isInvalid: boolean;
  isLogout: boolean;
  returnUrl = "/";
  submitted = false;
  model: any = {
    username: "",
    password: "",
    remembered: false,
  };

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    let params = this.route.snapshot.queryParamMap;
    this.isLogout = params.has("logout");
    this.returnUrl = params.get("returnUrl");
  }

  onSubmit() {
    this.submitted = true;
    this.userService.login(this.model).subscribe((user) => {
      if (user) {
        if (user.role == Role.Manager) {
          this.returnUrl = "/seller";
        }
        this.router.navigateByUrl(this.returnUrl);
      } else {
        this.isLogout = false;
        this.isInvalid = true;
      }
    });
  }
}
