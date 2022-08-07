import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProductCategory } from 'src/app/common/product-category';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-post-product',
  templateUrl: './post-product.component.html',
  styleUrls: ['./post-product.component.css'],
})
export class PostProductComponent implements OnInit {
  public ProductForm!: FormGroup;
  productId: any;

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private productsService: ProductService
  ) {}

  ngOnInit() {
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
  addNewProduct() {
    const createProduct = {
      id: this.productId,
      category: new ProductCategory(this.ProductForm.value.id),
      sku: this.ProductForm.value.sku,
      name: this.ProductForm.value.name,
      description: this.ProductForm.value.description,
      unitPrice: this.ProductForm.value.unitPrice,
      imageUrl: this.ProductForm.value.imageUrl,
      unitsInStock: this.ProductForm.value.unitsInStock,
    };

    console.log(createProduct);

    this.productsService.createProduct(createProduct).subscribe((data) => {
      console.log(data);
    });
  }
}
