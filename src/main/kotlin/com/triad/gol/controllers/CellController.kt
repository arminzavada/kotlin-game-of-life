package com.triad.gol.controllers

import com.triad.gol.models.Cell
import javafx.beans.property.SimpleIntegerProperty
import javafx.collections.FXCollections
import tornadofx.*

class CellController : Controller() {
    val widthProperty = SimpleIntegerProperty(5)
    var width by widthProperty

    val heightProperty = SimpleIntegerProperty(5)
    var height by heightProperty

    val cells = FXCollections.observableArrayList<Cell>()

    fun clear() {
        cells.clear()

        repeat(width * height) {
            cells.add(Cell())
        }
    }
}