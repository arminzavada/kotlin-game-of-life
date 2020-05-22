package com.triad.gol.models

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class Cell(val x: Int, val y: Int) {
    val isAliveProperty = SimpleBooleanProperty()
    var isAlive by isAliveProperty
}

