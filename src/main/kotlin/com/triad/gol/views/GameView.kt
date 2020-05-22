package com.triad.gol.views

import com.triad.gol.ApplicationStyle
import com.triad.gol.controllers.CellController
import tornadofx.*

class GameView : View() {
    private val cellController: CellController by inject()

    override val root = datagrid(cellController.cells) {
        maxRows = cellController.height
        maxCellsInRow = cellController.width
        cellWidth = 10.0
        cellHeight = 10.0
        verticalCellSpacing = 2.0
        horizontalCellSpacing = 2.0
        multiSelect = false
        singleSelect = false

        cellCache {
            button {
                toggleClass(ApplicationStyle.aliveCell, it.isAliveProperty)

                action {
                    it.isAlive = !it.isAlive
                }
            }
        }
    }
}