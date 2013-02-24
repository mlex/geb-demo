import geb.spock.GebReportingSpec

class SimpleSpec extends GebReportingSpec {
    def "create a new movie"() {
        given: "a user at add movie page"
        // go directly to base url
        // equivalent to: browser.go(baseUrl)
        go()

        // click on the new movie button and wait for the edit-form to appear
        $("a", text: "Add movie").click()
        waitFor { $("#pageContent form") }

        when: "the user creates a new movie"
        // fill the input form
        def form = $("#pageContent form")
        form.title = "Django Unchained"
        // It seems, there is a problem with input type=date in phantomjs, so we leave the date-field empty
        // form.startDate = "2012-01-17"
        form.description = "The latest Tarantino - a romantic movie?"

        // submit the form 
        form.find("button[type=submit]").click()
	

        then: "he can find the new movie in the movie list"
        // assert that the new movie is displayed in the movie-list
	// use waitFor, because the result is loaded via ajax
        waitFor {
            $("#pageContent tr")*.find("td", 0)*.text().contains("Django Unchained")
        }
    }
}
