package com.triad.gol.views

import com.triad.gol.controllers.CellController
import javafx.application.Platform
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import tornadofx.*

class MainMenuView : View("Triad - Game of Life") {
    private val cellController: CellController by inject()

    private val model = object : ViewModel() {
        val width = bind { SimpleIntegerProperty(5) }
        val height = bind { SimpleIntegerProperty(5) }
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
                        validator {
                            when {
                                it?.isInt() == false -> error("The field must be a number")
                                it?.toInt() !in 5..30 -> error("The field must be in the range of 5..30")
                                else -> null
                            }
                        }
                        filterInput {
                            it.controlNewText.isEmpty() || it.controlNewText.isInt()
                        }
                        whenDocked {
                            requestFocus()
                        }
                    }
                }
                field("Height") {
                    textfield(model.height) {
                        validator {
                            when {
                                it?.isInt() == false -> error("The field must be a number")
                                it?.toInt() !in 5..30 -> error("The field must be in the range of 5..30")
                                else -> null
                            }
                        }
                    }
                }
            }
            vbox(spacing = 10.0) {
                alignment = Pos.CENTER
                button("Start") {
                    isDefaultButton = true

                    enableWhen(model.valid)

                    action {
                        cellController.clear(model.width.value.toInt(), model.height.value.toInt())
                        replaceWith<CellGrid>()
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