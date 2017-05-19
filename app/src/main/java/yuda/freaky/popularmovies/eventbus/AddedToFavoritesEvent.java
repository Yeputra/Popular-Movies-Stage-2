package yuda.freaky.popularmovies.eventbus;

import yuda.freaky.popularmovies.api.MovieModel;

public class AddedToFavoritesEvent {
    MovieModel movie;

    public AddedToFavoritesEvent(MovieModel movie) {
        this.movie = movie;
    }

    public MovieModel getMovie() {
        return movie;
    }
}
