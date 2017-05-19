package yuda.freaky.popularmovies.eventbus;

import yuda.freaky.popularmovies.api.MovieModel;

public class RemovedFromFavoritesEvent {
    MovieModel movie;

    public RemovedFromFavoritesEvent(MovieModel movie) {
        this.movie = movie;
    }

    public MovieModel getMovie() {
        return movie;
    }
}
