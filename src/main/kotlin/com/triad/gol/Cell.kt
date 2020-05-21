package com.triad.gol

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class Cell {
    val isAliveProperty = SimpleBooleanProperty()
    var isAlive by isAliveProperty
}

class Map {
    val widthProperty = SimpleIntegerProperty()
    var width by widthProperty

    val heightProperty = SimpleIntegerProperty()
    var height by heightProperty

    val cells = listOf(Cell().apply { isAlive = true }, Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell()).observable()

    init {
        width = 3
        height = 3
    }
}