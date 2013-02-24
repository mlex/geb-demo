package support


class MovieDetailPage extends MovieDatabaseHomePage {
    static url = ""
    static at = {
        title == "Movie Database"
        movieDetail
        tagList
        searchBar
    }
    static content = {
        movieDetail { module MovieDetailModule }
        searchBar { module SearchBarModule }
        tagList { module TagListModule }
    }
}
