package com.triad.gol.controllers

import com.triad.gol.models.Cell
import javafx.beans.property.SimpleIntegerProperty
import javafx.collections.FXCollections
import tornadofx.*

class CellController : Controller() {
    val widthProperty = SimpleIntegerProperty()
    var width by widthProperty

    val heightProperty = SimpleIntegerProperty()
    var height by heightProperty

    val cells = FXCollections.observableArrayList<Cell>()

    fun clear(width: Int, height: Int) {
        this.width = width;
        this.height = height;

        cells.clear()

        repeat(width * height) {
            cells.add(Cell())
        }
    }
}