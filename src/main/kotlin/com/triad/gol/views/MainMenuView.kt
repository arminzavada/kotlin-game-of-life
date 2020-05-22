package com.triad.gol.views

import com.triad.gol.controllers.CellController
import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.TextFormatter
import tornadofx.*
class MainMenuView : View("Triad - Game of Life") {
    private val cellController: CellController by inject()
    private val numberFilter: (TextFormatter.Change) -> Boolean = { change ->
        !change.isAdded || change.controlNewText.let {
            it.isInt() && it.toInt() in 5..50
        }
    }

    override val root = vbox {
        alignment = Pos.CENTER
        prefWidth = 800.0
        prefHeight = 600.0

        form {
            maxWidth = 300.0

            fieldset("Map settings") {
                field("Width") {
                    textfield {
                        bind(cellController.widthProperty)
                        filterInput(numberFilter)
                        whenDocked {
                            requestFocus()
                        }
                    }
                }
                field("Height") {
                    textfield {
                        bind(cellController.heightProperty)
                        filterInput(numberFilter)
                    }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.CENTER
                button("Start") {
                    isDefaultButton = true

                    action {
                        cellController.clear()
                        replaceWith<GameView>()
                    }
                }
                button("Exit") {
                    isCancelButton = true

                    action {
                        Platform.exit()
                    }
                }
            }
        }
    }
}