package yuda.freaky.popularmovies.api;

import java.util.List;

public class TrailersResponse {
    List<TrailerModel> results;

    public List<TrailerModel> getResults() {
        return results;
    }

    public void setResults(List<TrailerModel> results) {
        this.results = results;
    }
}
