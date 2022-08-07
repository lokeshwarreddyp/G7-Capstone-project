import { ProductCategory } from './../../common/product-category';
import { ProductService } from 'src/app/services/product.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css'],
})
export class UpdateProductComponent implements OnInit {
  public ProductForm!: FormGroup;

  productId = 0;
  productDetails: Product | any;
  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private productsService: ProductService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((data) => {
      this.productId = data['id'];

      this.productsService
        .getProduct(this.productId)
        .subscribe((productData) => {
          this.productDetails = productData; // get the existing data of the product
          // console.log(this.productDetails);
        });
    });
    this.ProductForm = this.formBuilder.group({
      id: ['', [Validators.required]],
      category: this.formBuilder.group({
        id: ['', [Validators.required]],
      }),
      sku: ['', [Validators.required]],
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      unitPrice: ['', [Validators.required]],
      imageUrl: ['', [Validators.required]],
      unitsInStock: ['', [Validators.required]],
    });
  }

  updateProduct() {
    const updateProduct = {
      id: this.productId,
      category: new ProductCategory(this.ProductForm.value.id),
      sku: this.ProductForm.value.sku,
      name: this.ProductForm.value.name,
      description: this.ProductForm.value.description,
      unitPrice: this.ProductForm.value.unitPrice,
      imageUrl: this.ProductForm.value.imageUrl,
      unitsInStock: this.ProductForm.value.unitsInStock,
    };
    //console.log(form);
    this.productsService
      .updateProduct(this.productId, updateProduct)
      .subscribe((data) => {
        console.log(data);
      });
  }
}
