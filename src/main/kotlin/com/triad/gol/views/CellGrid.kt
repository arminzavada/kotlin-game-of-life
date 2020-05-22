package com.triad.gol.views

import com.triad.gol.ApplicationStyle
import com.triad.gol.controllers.GameController
import javafx.geometry.Pos
import javafx.scene.input.MouseEvent
import tornadofx.*


class CellGrid : View() {
    private val gameController: GameController by inject()

    override val root = hbox {
        alignment = Pos.CENTER

        addClass(ApplicationStyle.cellGridContainer)

        vbox {
            alignment = Pos.CENTER

            datagrid(gameController.cells) {
                usePrefSize = true
                prefWidth = gameController.width * 22.0
                prefHeight = gameController.height * 22.0
                maxRows = gameController.height
                maxCellsInRow = gameController.width

                addClass(ApplicationStyle.cellGrid)

                cellCache { cell ->
                    pane {
                        useMaxSize = true

                        addClass(ApplicationStyle.cellClass)
                        toggleClass(ApplicationStyle.aliveCellClass, cell.isAliveProperty)

                        addEventHandler(MouseEvent.MOUSE_CLICKED) {
                            gameController.place(cell.x, cell.y)
                        }
                    }
                }
            }
        }
    }
}