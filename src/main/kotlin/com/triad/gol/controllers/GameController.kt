package com.triad.gol.controllers

import com.triad.gol.models.Cell
import com.triad.gol.models.Map
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import tornadofx.*

class GameController : Controller() {
    private lateinit var map: Map

    val widthProperty = SimpleIntegerProperty()
    var width by widthProperty

    val heightProperty = SimpleIntegerProperty()
    var height by heightProperty

    val speedPropety = SimpleObjectProperty<Speed>()
    var speed by speedPropety

    val isRunningProperty = SimpleBooleanProperty(false)
    var isRunning by isRunningProperty

    val cells = FXCollections.observableArrayList<Cell>()

    fun clear(width: Int, height: Int) {
        this.width = width
        this.height = height
        map = Map(width, height)

        cells.clear()
        cells.addAll(map.cells)
    }

    fun step() {
        map.nextState()
    }
}