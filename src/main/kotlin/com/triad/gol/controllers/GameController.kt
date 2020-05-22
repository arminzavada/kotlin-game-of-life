package com.triad.gol.controllers

import com.triad.gol.models.Cell
import com.triad.gol.models.Map
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tornadofx.Controller
import tornadofx.getValue
import tornadofx.onChange
import tornadofx.setValue

class GameController : Controller() {
    private lateinit var map: Map

    val widthProperty = SimpleIntegerProperty()
    var width by widthProperty

    val heightProperty = SimpleIntegerProperty()
    var height by heightProperty

    val speedPropety = SimpleIntegerProperty(800)
    var speed by speedPropety

    val isRunningProperty = SimpleBooleanProperty()
    var isRunning by isRunningProperty

    val isPausedProperty = SimpleBooleanProperty()
    var isPaused by isPausedProperty

    val cells = FXCollections.observableArrayList<Cell>()

    init {
        isRunningProperty.onChange {
            if (it) {
                GlobalScope.launch {
                    while (isRunning) {
                        step()
                        delay(speed.toLong())
                    }
                }
            }
        }

        isPausedProperty.bind(isRunningProperty.not()) // I had to add the isPausedProperty, because isRunningProperty.not() did not return a valid observable property. It might be a bug, I don't know.
    }

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