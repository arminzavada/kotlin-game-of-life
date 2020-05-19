package com.triad.gol

import javafx.collections.FXCollections
import tornadofx.getProperty
import tornadofx.property

class Cell {
    var isAlive by property<Boolean>()
    fun isAliveProperty() = getProperty(Cell::isAlive)
}

class Map {
    val cellList = FXCollections.observableArrayList<Cell>()
}