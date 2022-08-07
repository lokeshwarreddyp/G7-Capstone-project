import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  status = '';
  errorMessage = '';
  private baseUrl = 'http://localhost:8080/api/products';

  private categoryUrl = 'http://localhost:8080/api/product-category';

  constructor(private httpClient: HttpClient, private router: Router) {}

  getProduct(theProductId: number): Observable<Product> {
    // need to build URL based on product id
    const productUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get<Product>(productUrl);
  }

  getProductListPaginate(
    thePage: number,
    thePageSize: number,
    theCategoryId: number
  ): Observable<Product[]> {
    // need to build URL based on category id, page and size
    const searchUrl =
      `${this.baseUrl}/search/findByCategoryId/${theCategoryId}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<Product[]>(searchUrl);
  }

  getProductListPaginateSort(
    thePage: number,
    thePageSize: number,
    theCategoryId: number
  ): Observable<Product[]> {
    // need to build URL based on category id, page and size
    const searchUrl =
      `${this.baseUrl}/search/findByCategoryId/sortByPrice/${theCategoryId}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<Product[]>(searchUrl);
  }

  getProductList(theCategoryId: number): Observable<Product[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/search/findByCategoryId/${theCategoryId}`;

    return this.getProducts(searchUrl);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    // need to build URL based on the keyword
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;

    return this.getProducts(searchUrl);
  }

  searchProductsPaginate(
    thePage: number,
    thePageSize: number,
    theKeyword: string
  ): Observable<Product[]> {
    // need to build URL based on keyword, page and size
    const searchUrl =
      `${this.baseUrl}/search/findByNameContaining/${theKeyword}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<Product[]>(searchUrl);
  }

  searchProductsPaginateSort(
    thePage: number,
    thePageSize: number,
    theKeyword: string
  ): Observable<Product[]> {
    // need to build URL based on keyword, page and size
    const searchUrl =
      `${this.baseUrl}/search/findByNameContaining/sortByPrice/${theKeyword}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<Product[]>(searchUrl);
  }

  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(searchUrl);
  }

  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseUrl);
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<ProductCategory[]>(this.categoryUrl);
  }

  deleteProduct(productId: number) {
    const deleteUrl = `http://localhost:8080/api/admin/product/delete/${productId}`;
    this.httpClient.delete(deleteUrl).subscribe();
    this.router.navigateByUrl('/products');
  }

  updateProduct(productId: number, productBody: Product): Observable<Product> {
    const productUrl = `http://localhost:8080/api/admin/product/edit/${productId}`;
    return this.httpClient.put<Product>(productUrl, productBody);
  }

  createProduct(productBody:Product): Observable<Product>{
    const productUrl = `http://localhost:8080/api/admin/product/new`;

    return this.httpClient.post<Product>(productUrl, productBody); // return an observable
  }
}
