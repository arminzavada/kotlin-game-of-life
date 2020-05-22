package com.triad.gol.models

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class Cell {
    val isAliveProperty = SimpleBooleanProperty()
    var isAlive by isAliveProperty
}

