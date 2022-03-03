package file

import java.io.File
import java.io.IOException

class FileManager {
    fun read(name: String, isResource: Boolean = true): List<String> {
        if (!name.endsWith(".md")) {
            throw InvalidFileFormatException()
        }
        val text = if (isResource) getResourceAsText(name) else getFileAsText(name)
        return text.lines()
    }

    fun write(name: String, content: String) {
        File("$name.html").writeText(content)
    }

    private fun getResourceAsText(path: String): String =
        javaClass.getClassLoader().getResourceAsStream(path).reader().readText()

    private fun getFileAsText(path: String): String =
        File(path).readText()
}

class InvalidFileFormatException : IOException("we only support .md files ¯\\_(ツ)_/¯")