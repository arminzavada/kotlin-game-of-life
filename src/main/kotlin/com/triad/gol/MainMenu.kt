package com.triad.gol

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class MainMenuStyle : Stylesheet() {
    init {
        label {
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            backgroundColor += c("#cecece")
        }
    }
}

class MainMenuView : View() {
    override val root = pane {
        prefWidth = 400.0
        prefHeight = 300.0

        vbox {
            alignment = Pos.CENTER
            spacing = 10.0

            button("Start") {
                action {
                    replaceWith(GameView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
                }
            }
            button("Exit") {
                action {
                    Platform.exit()
                }
            }
        }
    }
}

class Application : App(MainMenuView::class, MainMenuStyle::class)

fun main() {
    launch<Application>();
}