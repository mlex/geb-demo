import geb.spock.GebReportingSpec
import support.MovieDatabaseHomePage
import support.SearchResultPage

class SearchSpec extends GebReportingSpec {

    def "search for movie"() {
        given: "a user at the moviedatabase homepage"
        toAt MovieDatabaseHomePage

        when: "the user searches for 'Star'"
        searchBar.searchFor("Star")

        then: "the search result contains the movie 'Star Wars'"
        // this will not work, when the server is too slow and the content is loaded via ajax
        //at new SearchResultPage(searchString: "Star")
        waitFor { at new SearchResultPage(searchString: "Star") }
        searchResult.containsMovie("Star Wars")
    }


    def "search for non-existant movie"() {
        given: "a user at the moviedatabase homepage"
        toAt MovieDatabaseHomePage

        when: "the user searches for 'Foo'"
        searchBar.searchFor("Foo")

        then: "the search-result does not contain the movie 'Star Wars'"
        waitFor { at new SearchResultPage(searchString: "Foo") }
        assert !searchResult.containsMovie("Star Wars")
    }

}