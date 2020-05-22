package com.triad.gol.views

import com.triad.gol.controllers.GameController
import tornadofx.*

class PatternList : View() {
    val gameController: GameController by inject()

    override val root = listview(gameController.patterns) {
        bindSelected(gameController.patternProperty)
        selectionModel.select(0)
        isEditable = false
        cellFragment(PatternItemFragment::class)
    }
}