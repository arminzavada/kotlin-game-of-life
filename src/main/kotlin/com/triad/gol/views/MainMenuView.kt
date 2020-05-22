package com.triad.gol.views

import com.triad.gol.controllers.GameController
import com.triad.gol.models.Map
import javafx.application.Platform
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import javafx.scene.control.TextFormatter
import tornadofx.*

class MainMenuView : View("Triad - Game of Life") {
    private val gameController: GameController by inject()
    private val model = object : ViewModel() {
        val width = bind { SimpleIntegerProperty(5) }
        val height = bind { SimpleIntegerProperty(5) }
    }
    private val numberFilter: (TextFormatter.Change) -> Boolean = {
//        if (it.isDeleted && it.controlNewText.isEmpty()) {
//            it.text = "0"
//            it.
//            it.caretPosition = 1
//            it.anchor = 1
//        } else if (it.isAdded && it.controlText == "0") {
//            it.text = it.controlNewText.drop(1)
//            it.caretPosition = 1
//            it.anchor = 1
//        }

        !it.isAdded || it.controlNewText.isInt()
    }
    private val numberValidator: ValidationContext.(String?) -> ValidationMessage? = {
        when {
            it?.isInt() == false -> error("The field must be a number")
            it?.toInt() !in 5..50 -> error("The field must be in the range of 5..50")
            else -> null
        }
    }

    override val root = vbox {
        alignment = Pos.CENTER
        prefWidth = 800.0
        prefHeight = 600.0

        form {
            maxWidth = 300.0

            fieldset("Map settings") {
                field("Width") {
                    textfield(model.width) {
                        promptText = "The width of the map, 5..50"

                        validator(ValidationTrigger.OnChange(), numberValidator)
                        filterInput(numberFilter)
                        whenDocked {
                            requestFocus()
                        }
                    }
                }
                field("Height") {
                    textfield(model.height) {
                        promptText = "The height of the map, 5..50"

                        validator(ValidationTrigger.OnChange(), numberValidator)
                        filterInput(numberFilter)
                    }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.CENTER

                button("Start") {
                    isDefaultButton = true

                    enableWhen(model.valid)
                    action {
                        gameController.map = Map(model.width.value.toInt(), model.height.value.toInt())
                        replaceWith<GameView>()
                    }
                }
                button("Exit") {
                    isCancelButton = true

                    action {
                        Platform.exit()
                    }
                }
            }
        }
    }
}