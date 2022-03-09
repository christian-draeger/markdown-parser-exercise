import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import converter.Converter
import converter.convertToHtml
import file.FileManager
import file.readMd
import java.io.File

fun main2(args: Array<String>) {

    println(File("example.md").readMd().convertToHtml())

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")
}


class Hello: CliktCommand() {
    val input by option(help="the input md-file").prompt("Input")
    val outputName by option(help="the output html-file").prompt("the html files name")

    override fun run() {
        File(input).readMd().convertToHtml().run {
            File("$outputName.html").writeText(this)
        }
    }
}

fun main(args: Array<String>) = Hello().main(args)