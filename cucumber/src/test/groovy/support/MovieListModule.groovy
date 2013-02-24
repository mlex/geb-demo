package support

import geb.Module


class MovieListModule extends Module {
    static base = { $("#pageContent") }
    static content = {
        movieCount { $("tr").size() }
        movie(required: false) { movieName -> $("td", text: movieName).parent() }
        containsMovie(required: false) { movieName ->  movie(movieName).present }
    }
}
