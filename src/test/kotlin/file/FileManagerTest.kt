package file

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class FileManagerTest {

    private val fileManager = FileManager()

    @Test
    fun `can read from resources folder by default`() {
        val result = fileManager.read("example.md")
        assertEquals("# example document from resources folder", result[0])
    }

    @Test
    fun `can read from project root folder`() {
        val result = fileManager.read(name = "example.md", isResource = false)
        assertEquals("# example document from project root", result[0])
    }

    @Test
    fun `will throw exception on none 'md' files`() {
        assertThrows(InvalidFileFormatException::class.java) {
            fileManager.read(name = "example.txt")
        }
    }

    @Test
    fun `can write to file`() {
        val aMultilineString = """
            some content
            on multiple
            lines.
        """.trimIndent()

        fileManager.write(name = "test", content = aMultilineString)

        assertTrue(File("test.html").readText().contains(aMultilineString))
    }
}
