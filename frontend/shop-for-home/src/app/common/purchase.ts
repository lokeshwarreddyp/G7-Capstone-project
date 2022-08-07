import { Customer } from './customer';
import { Order } from './order';
import { OrderItem } from './order-item';

export class Purchase {
    customer: Customer | undefined;
    order: Order | undefined;
    orderItems: OrderItem[] | undefined;
}
