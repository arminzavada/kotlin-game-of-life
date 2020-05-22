package com.triad.gol.views

import com.triad.gol.controllers.GameController
import com.triad.gol.controllers.Speed
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import tornadofx.*

class PlayController : View("My View") {
    private val gameController: GameController by inject()

    override val root = hbox(2.0) {
        paddingAll = 2.0

        val toggleGroup = togglegroup()

        iconButton(FontAwesomeIcon.STEP_FORWARD) {
            action {
                toggleGroup.selectToggle(toggleGroup.toggles.first())
                gameController.step()
            }
        }
        iconToggleButton(FontAwesomeIcon.PAUSE, toggleGroup) {
            action {
                gameController.isRunning = false
            }
        }
        iconToggleButton(FontAwesomeIcon.PLAY, toggleGroup) {
            action {
                gameController.isRunning = true
                gameController.speed = Speed.Normal
            }
        }
        iconToggleButton(FontAwesomeIcon.FAST_FORWARD, toggleGroup) {
            action {
                gameController.isRunning = true
                gameController.speed = Speed.Fast
            }
        }
    }
}
