import { PostProductComponent } from './components/post-product/post-product.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { AllProductsComponent } from './components/all-products/all-products.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  //{ path: 'checkout', component: CheckoutComponent },
  {path:'login' ,component:LoginComponent},
  {path:'register' ,component:RegisterComponent},
  { path: 'cart-details', component: CartDetailsComponent },
  { path: 'all-products', component: AllProductsComponent },
  { path: 'update-product/:id', component: UpdateProductComponent },
  { path: 'post-product', component: PostProductComponent },
  { path: 'search/:keyword', component: ProductListComponent },
  //{ path: 'sort/:direction', component: ProductListComponent },
  //{ path: 'category/:id', component: ProductListComponent },
  { path: 'products/:id', component: ProductDetailsComponent },
  //{ path: 'category', component: ProductListComponent },
  { path: 'products', component: ProductListComponent },
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: '**', redirectTo: '/products', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
