import geb.spock.GebReportingSpec
import support.MovieDatabaseHomePage
import support.MovieDetailPage

class MovieSpec extends GebReportingSpec {

    def "go to movie detail page"() {
        given: "a user at the homepage containing the movie 'Star Wars'"
        toAt MovieDatabaseHomePage
        movieList.containsMovie("Star Wars")

        when: "the user clicks on the movie 'Star Wars'"
        movieList.movie("Star Wars").find("a", 0).click()

        then: "the detail page for this movie is displayed"
        at MovieDetailPage
        movieDetail.title == "Star Wars"
        movieDetail.description.contains "In einer Galaxie weit, weit entfernt"
    }

}