import { Router } from '@angular/router';
import { Component, OnInit } from "@angular/core";
import { Product } from "src/app/common/product";
import { ProductService } from "src/app/services/product.service";

@Component({
  selector: "app-all-products",
  templateUrl: "./all-products.component.html",
  styleUrls: ["./all-products.component.css"],
})
export class AllProductsComponent implements OnInit {
  products: Product[] = [];

  constructor(
    private productService: ProductService,
    private route:Router
  ) {}

  ngOnInit() {
    this.productService
      .getAllProducts()
      .subscribe((data) => (this.products = data));
  }

  deleteProduct(product:Product){
    this.productService.deleteProduct(product.id as any);
  }
}
