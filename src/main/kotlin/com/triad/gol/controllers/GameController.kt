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
import tornadofx.*

class GameController : Controller() {
    var map: Map = Map(5, 5)
        set(value) {
            cells.clear()
            cells.addAll(value.cells)

            field = value
        }

    val width
        get() = map.width
    val height
        get() = map.height

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

    fun clear() {
        map.clear()
    }

    fun step() {
        map.nextState()
    }
}