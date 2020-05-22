package com.triad.gol.views

import com.triad.gol.ApplicationStyle
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.event.EventTarget
import javafx.scene.control.Button
import javafx.scene.control.ToggleButton
import javafx.scene.control.ToggleGroup
import tornadofx.addClass
import tornadofx.button
import tornadofx.getToggleGroup
import tornadofx.togglebutton

fun EventTarget.iconButton(icon: FontAwesomeIcon, op: Button.() -> Unit = {}) = this.button {
    graphic = FontAwesomeIconView(icon).apply {
        glyphSize = 22
        addClass(ApplicationStyle.icon)
    }
    addClass(ApplicationStyle.iconButton)

    op(this)
}
fun EventTarget.iconToggleButton(
    icon: FontAwesomeIcon,
    group: ToggleGroup? = getToggleGroup(),
    op: ToggleButton.() -> Unit = {}
) = this.togglebutton(group) {
    graphic = FontAwesomeIconView(icon).apply {
        glyphSize = 22
        addClass(ApplicationStyle.icon)
    }
    addClass(ApplicationStyle.iconButton)

    op(this)
}