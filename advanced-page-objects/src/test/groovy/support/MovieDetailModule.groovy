package support

import geb.Module


class MovieDetailModule extends Module {
    static base = { $("#pageContent") }
    static content = {
        title { $("div.row", 0).text() }
        releaseDate { $("div.row", 1).text()}
        description {$("div.row", 2).text() }
        editButton {$("a.btn", text: "Edit")}
        commentsButton {$("a.btn", text: "Comments") }
        tagsButton {$("a.btn", text: "Tags")}
    }
}
