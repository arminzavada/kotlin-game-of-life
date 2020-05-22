package com.triad.gol.models

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*

class Pattern(name: String, width: Int, height: Int, val flip: Boolean, pattern: List<Boolean>) {
    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty
    val widthProperty = SimpleIntegerProperty(width)
    var width by widthProperty
    val heightProperty = SimpleIntegerProperty(height)
    var height by heightProperty

    var pattern = FXCollections.observableArrayList(pattern)

    operator fun get(x: Int, y: Int): Boolean {
        return if (x in 0 until width && y in 0 until height) pattern[y * width + x]
        else false
    }
}

class PatternModel(property: ObjectProperty<Pattern>) : ItemViewModel<Pattern>(itemProperty = property) {
    val name = bind(autocommit = true) {
        item?.nameProperty
    }
}