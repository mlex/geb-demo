package step_definitions

import support.MovieDatabaseHomePage
import support.SearchResultPage

this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~'I am on the moviedatabase homepage') {->
    browser.toAt MovieDatabaseHomePage
}

When(~'I search for "([^"]*)"') { String searchTerm ->
    page.searchBar.searchFor(searchTerm)

}

Then(~'I should see the search result for "([^"]*)"') { String searchTerm ->
    browser.waitFor { at new SearchResultPage(searchString: searchTerm) }

}

Then(~'The result should contain "([^\"]*)"') { String searchTerm ->
    page.searchResult.containsMovie(searchTerm)
}

