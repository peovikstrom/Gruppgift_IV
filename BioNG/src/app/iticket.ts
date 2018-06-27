import { IShow } from './ishow';
import { ICustomer } from './icustomer';

export interface ITicket {
    id: number;
    show: IShow;
    seatrow: number;
    seatcol: number;
    customer: ICustomer;
}
