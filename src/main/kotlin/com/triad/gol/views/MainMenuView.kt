package com.triad.gol.views

import com.triad.gol.controllers.CellController
import javafx.application.Platform
import javafx.geometry.Pos
import tornadofx.*

class MainMenuView : View() {
    private val cellController: CellController by inject()

    override val root = vbox {
        prefWidth = 400.0
        prefHeight = 300.0
        alignment = Pos.CENTER
        spacing = 10.0

        button("Start") {
            action {
                cellController.clear(10, 10)
                replaceWith<GameView>()
            }
        }
        button("Exit") {
            action {
                Platform.exit()
            }
        }
    }
}