package com.triad.gol.views

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import tornadofx.*

class PlayController : View("My View") {
    override val root = hbox(2.0) {
        paddingAll = 2.0

        val toggleGroup = togglegroup()

        iconButton(FontAwesomeIcon.STEP_FORWARD) {
            action {
                toggleGroup.selectToggle(toggleGroup.toggles.first())
            }
        }
        iconToggleButton(FontAwesomeIcon.PAUSE, toggleGroup) {

        }
        iconToggleButton(FontAwesomeIcon.PLAY, toggleGroup) {

        }
        iconToggleButton(FontAwesomeIcon.FAST_FORWARD, toggleGroup) {

        }
    }
}
