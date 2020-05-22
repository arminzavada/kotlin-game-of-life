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

        vbox {
            alignment = Pos.CENTER

            datagrid(gameController.cells) {
                maxRows = gameController.height
                maxCellsInRow = gameController.width
                cellWidth = 28.0
                cellHeight = 28.0
                verticalCellSpacing = 1.0
                horizontalCellSpacing = 1.0

                alignment = Pos.CENTER

                addClass(ApplicationStyle.cellGrid)

                cellCache { cell ->
                    pane {
                        useMaxHeight = true
                        useMaxWidth = true

                        addClass(ApplicationStyle.cellClass)
                        toggleClass(ApplicationStyle.aliveCellClass, cell.isAliveProperty)

                        addEventHandler(MouseEvent.MOUSE_CLICKED) {
                            cell.isAlive = !cell.isAlive
                        }
                    }
                }
            }
        }
    }
}