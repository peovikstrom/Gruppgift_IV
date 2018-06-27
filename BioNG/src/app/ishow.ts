import { IMovie } from './imovie';
import { ITheatre } from './itheatre';


export interface IShow {
    tickets: number[];
    theatreId: number;
    id: number;
    start: string;
    stop: string;
    movie: IMovie;
    theatre: ITheatre;
}
