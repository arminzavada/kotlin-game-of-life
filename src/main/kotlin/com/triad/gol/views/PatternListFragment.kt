package com.triad.gol.views

import com.triad.gol.controllers.GameController
import com.triad.gol.models.Pattern
import com.triad.gol.models.PatternModel
import tornadofx.*

class PatternItemFragment : ListCellFragment<Pattern>() {
    val gameController: GameController by inject()
    val pattern = PatternModel(itemProperty)

    override val root = hbox {
        text(pattern.name)
    }
}