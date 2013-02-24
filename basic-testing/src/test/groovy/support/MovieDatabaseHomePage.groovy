package support

import geb.Page

class MovieDatabaseHomePage extends Page {
    static url = ""

    static content = {
        // content templates are defined using a simple dsl:
        // <name> (<options map>) { <definition> }
        searchForm { $("#searchbar .form-search") }

        // the <definition> is evaluated against the page-instance,
        // so calling other templates is possible
        searchTextField { searchForm.find("input[name=searchString]") }

        // templates can be used to execute actions, too
        searchSubmitButton { searchForm.find(type: "submit") }

        // it is also possible to pass arguments to templates
        searchFor { searchTerm ->
            searchTextField.value(searchTerm)
            searchSubmitButton.click()
        }

        // if a template returns a Navigator object, geb normally throws an
        // RequiredPageContentNotPresent, when the no content is found
        // setting the option "required" to false disables this behaviour
        movies(required: false) { $("#pageContent tr") }

        // required=true is the default
        movie(required: true) { index -> movies.find(index) }

        // templates can return arbitrary data
        movieCount() { movies().size() }
        movieTitle { index -> movie(index).text() }
    }
}
