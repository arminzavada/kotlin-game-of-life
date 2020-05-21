package com.triad.gol

import javafx.application.Platform
import javafx.geometry.Pos
import tornadofx.*

class MainMenuStyle : Stylesheet() {
    companion object {
        val aliveCell by cssclass()
    }

    init {
        button {
            backgroundColor += c("#ffffff")
        }
        aliveCell {
            backgroundColor += c("#000000")
        }
    }
}

class MainMenuView : View() {
    override val root = vbox {
        prefWidth = 400.0
        prefHeight = 300.0
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

class Application : App(MainMenuView::class, MainMenuStyle::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}

fun main() {
    launch<Application>();
}