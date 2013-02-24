import geb.spock.GebReportingSpec
import support.MovieDatabaseHomePage

class SearchSpec extends GebReportingSpec {

    def "search for movie"() {
        given: "a user at the moviedatabase homepage"
        // set the current page object to an instance of MovieDatabaseHomePage
        to MovieDatabaseHomePage

        when: "the user searches for 'Star'"
        // equivalent to: browser.page.searchFor("Star")
        searchFor("Star")

        then: "the search result contains the movie 'Star Wars'"
        // equivalent to: assert browser.page.movieTitle(0) == "Star Wars"
        movieTitle(0) == "Star Wars"
    }

    def "search for nonexistant movie"() {
        given: "a user at the moviedatabase homepage"
        to MovieDatabaseHomePage

        when: "the user searches for 'Foo'"
        searchFor("Foo")

        then: "the search result is empty"
        movieCount() == 0
    }

}