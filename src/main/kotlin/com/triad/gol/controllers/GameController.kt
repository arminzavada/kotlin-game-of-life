package com.triad.gol.controllers

import com.triad.gol.models.Cell
import com.triad.gol.models.Map
import com.triad.gol.models.Pattern
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

    val patterns = FXCollections.observableArrayList(
        Pattern("Normal", 1, 1, true, listOf(true)),
        Pattern("Block", 2, 2, false, listOf(true, true, true, true)),
        Pattern("Blinker", 3, 3, false, listOf(false, false, false, true, true, true, false, false, false)),
        Pattern("Glider", 3, 3, false, listOf(false, true, false, false, false, true, true, true, true))
    )

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

    val patternProperty = SimpleObjectProperty(patterns.first())
    var pattern by patternProperty

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

    fun place(cellX: Int, cellY: Int) {
        val deltaX = cellX - pattern.width / 2
        val deltaY = cellY - pattern.height / 2

        for (x in 0 until pattern.width) {
            for (y in 0 until pattern.width) {
                if (pattern.flip) {
                    map[x + deltaX, y + deltaY] = map[x + deltaX, y + deltaY] xor pattern[x, y]
                } else {
                    map[x + deltaX, y + deltaY] = pattern[x, y]
                }
            }
        }
    }

    fun clear() {
        map.clear()
    }

    fun step() {
        map.nextState()
    }
}