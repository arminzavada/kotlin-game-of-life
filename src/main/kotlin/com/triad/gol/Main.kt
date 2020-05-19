package com.triad.gol

import javafx.scene.text.FontWeight
import tornadofx.*

class HelloWorld : View() {
    override val root = hbox {
        label("Hello world")
    }
}
class HelloWorldApp : App(HelloWorld::class, Styles::class)

fun main() {
    launch<HelloWorldApp>();
}

class Styles : Stylesheet() {
    init {
        label {
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            backgroundColor += c("#cecece")
        }
    }
}