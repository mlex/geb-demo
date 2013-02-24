package support

import geb.Page


class SearchResultPage extends Page {
    def searchString

    static at = {
        // TODO The search result page should have a different title than the homepage
        title == "Movie Database"
        searchResult.searchString == searchString
        searchBar
    }

    static content = {
        searchBar { module SearchBarModule }
        searchResult { module SearchResultModule }
    }
}
