package converter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConverterTest {

    private val converter = Converter()

    private val testData = listOf(
        "# a h1",
        "## a h2",
        "a paragraph",
        "   ",
        "# h1 with ## nested h2"
    )

    @Test
    fun `just print doc for showcasing reasons`() {
        println(converter.toHtml(testData))
    }

    @Test
    fun `can convert h1`() {
        assertTrue(converter.toHtml(testData).contains("<h1>a h1</h1>"))
    }

    @Test
    fun `can convert h2`() {
        assertTrue(converter.toHtml(testData).contains("<h2>a h2</h2>"))
    }

    @Test
    fun `can convert paragraph`() {
        assertTrue(converter.toHtml(testData).contains("<p>a paragraph</p>"))
    }

    @Test
    fun `can convert line breaks`() {
        assertTrue(converter.toHtml(testData).contains("<br />"))
    }

    @Test
    fun `will ignore nested one liners`() {
        assertTrue(converter.toHtml(testData).contains("<h1>h1 with ## nested h2</h1>"))
    }


}