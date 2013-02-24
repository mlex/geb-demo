import geb.spock.GebReportingSpec
import support.MovieDatabaseHomePage
import support.SearchResultPage

class TagSpec extends GebReportingSpec {

    def "click on tag"() {
        given: "a user at the moviedatabase homepage"
        toAt MovieDatabaseHomePage

        when: "the user clicks on the tag 'Science Fiction'"
        tagList.tag("Science Fiction").click()

        then: "a search for 'tag:Science Fiction' is triggered"
        searchBar.form.searchString == "tag:'Science Fiction'"
        waitFor { at new SearchResultPage(searchString: "tag:'Science Fiction'") }

        and: "the search result contains the movie 'Star Wars'"
        searchResult.containsMovie("Star Wars")
    }

}