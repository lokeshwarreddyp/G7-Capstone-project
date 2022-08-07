import { ProductCategory } from './product-category';
export class Product {
    id: number | undefined;
    sku: string | undefined;
    name: string | undefined;
    description: string | undefined;
    unitPrice: number | undefined;
    imageUrl: string | undefined;
    unitsInStock: number | undefined;
    category:ProductCategory|undefined
}
