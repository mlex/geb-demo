import geb.spock.GebReportingSpec
import support.MovieDatabaseHomePage

class HomePageSpec extends GebReportingSpec {

    def "visit moviedatabase homepage"() {
        when: "the user goes to the moviedatabase homepage"
        to MovieDatabaseHomePage

        then: "he can see the moviedatabase homepage"
        at MovieDatabaseHomePage

        and: "the movielist contains 'Star Wars'"
        movieList.containsMovie("Star Wars")

        and: "the taglist contains 'Science Fiction'"
        tagList.containsTag("Science Fiction")
    }

}