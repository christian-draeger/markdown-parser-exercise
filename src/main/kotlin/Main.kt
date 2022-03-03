import converter.Converter
import file.FileManager

fun main(args: Array<String>) {

    val fileManager = FileManager()
    val converter = Converter()

    val lines = fileManager.read("example.md")
    val html = converter.toHtml(lines)

    println(html)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")
}