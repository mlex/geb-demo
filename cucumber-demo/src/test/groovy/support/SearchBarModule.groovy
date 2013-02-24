package support

import geb.Module


class SearchBarModule extends Module {
    static base = { $("#searchbar") }
    static content = {
        form { $(".form-search") }
        submitButton { form.find(type: "submit")}
        searchFor { searchTerm ->
            form.searchString = searchTerm
            submitButton.click()
        }
    }
}
