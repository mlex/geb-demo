package support

import geb.Module


class SearchResultModule extends MovieListModule {
    static base = { $("#pageContent") }
    static content = {
        searchDescription {$(".searchDescription")}
        searchString {searchDescription().find(".searchString").text()}
    }
}
