package com.triad.gol.views

import tornadofx.*

class GameView : View("Game of Life") {
    override val root = borderpane {
        center(CellGrid::class)
        right(PlayController::class)
    }
}
