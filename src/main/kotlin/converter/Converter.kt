package converter

fun List<String>.convertToHtml() = Converter().toHtml(this)

class Converter {
    fun toHtml(markdownLines: List<String>): String {
        return markdownLines.joinToString(transform = ::lineConverter, separator = "\n")
    }

    private fun lineConverter(line: String): String = when {
        line.startsWith("# ") -> line.replaceFirst("# ", "<h1>") + "</h1>"
        line.startsWith("## ") -> line.replaceFirst("## ", "<h2>") + "</h2>"
        line.startsWith("> ") -> line.replaceFirst("> ", "<blockquote>") + "</blockquote>"
        line.isBlank() -> "<br />"
        else -> "<p>$line</p>"
    }
}
