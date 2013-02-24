package support

import geb.Module


class TagListModule extends Module {
    static base = { $("#tagsAll") }
    static content = {
        tag(required: false) { tagName -> $("li a", text: tagName) }
        containsTag(required: false) {tagName -> tag(tagName).present }
    }
}
