package com.triad.gol

import tornadofx.*

class GameView : View() {
    val map = Map()

    override val root = datagrid(map.cells) {
        maxRows = map.height
        maxCellsInRow = map.width
        cellWidth = 10.0
        cellHeight = 10.0
        verticalCellSpacing = 2.0
        horizontalCellSpacing = 2.0
        multiSelect = false
        singleSelect = false

        cellCache {
            button {
                toggleClass(MainMenuStyle.aliveCell, it.isAliveProperty)
            }
        }
    }
}