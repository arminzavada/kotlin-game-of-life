package com.triad.gol.views

import com.triad.gol.ApplicationStyle
import com.triad.gol.controllers.GameController
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import javafx.beans.binding.Bindings
import javafx.geometry.Pos
import tornadofx.*

class PlayController : View("My View") {
    private val gameController: GameController by inject()

    override val root = vbox {
        addClass(ApplicationStyle.controlPanel)

        label("Game Of Life").setId(ApplicationStyle.title)

        slider(100..1000) {
            this.valueProperty().bindBidirectional(gameController.speedPropety)
        }

        hbox {
            addClass(ApplicationStyle.controlPanelButtonsContainer)

            iconButton(FontAwesomeIcon.STEP_FORWARD) {
                action {
                    gameController.isRunning = false
                    gameController.step()
                }
            }
            iconButton(FontAwesomeIcon.ERASER)
            iconButton(FontAwesomeIcon.PAUSE) {
                toggleClass(Stylesheet.selected, gameController.isPausedProperty)

                action {
                    gameController.isRunning = false
                }
            }
            iconButton(FontAwesomeIcon.PLAY) {
                toggleClass(Stylesheet.selected, gameController.isRunningProperty)

                action {
                    gameController.isRunning = true
                }
            }
        }
    }
}
