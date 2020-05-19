package com.triad.gol

import javafx.application.Platform
import javafx.geometry.Pos
import tornadofx.*


class GameView : View() {
    override val root = hbox {
        paddingAll = 50
        text("I am game View!")
    }
}