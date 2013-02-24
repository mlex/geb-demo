package support

import geb.Page


class MovieDatabaseHomePage extends Page {
    static url = ""

    static at = {
        title == "Movie Database"
        tagList
        searchBar
        movieList
    }

    static content = {
        searchBar { module SearchBarModule }
        tagList { module TagListModule }
        movieList { module MovieListModule }
    }
}
