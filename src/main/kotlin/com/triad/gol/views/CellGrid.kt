package com.triad.gol.views

import com.triad.gol.ApplicationStyle
import com.triad.gol.controllers.CellController
import javafx.geometry.Pos
import javafx.scene.input.MouseEvent
import tornadofx.*


class CellGrid : View() {
    private val cellController: CellController by inject()

    override val root = gridpane {
        alignment = Pos.CENTER

        datagrid(cellController.cells) {
            prefWidthProperty().bind(cellController.widthProperty.times(30))
            prefHeightProperty().bind(cellController.heightProperty.times(30))

            maxRows = cellController.height
            maxCellsInRow = cellController.width
            cellWidth = 28.0
            cellHeight = 28.0
            verticalCellSpacing = 1.0
            horizontalCellSpacing = 1.0
            usePrefHeight = true
            usePrefWidth = true

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