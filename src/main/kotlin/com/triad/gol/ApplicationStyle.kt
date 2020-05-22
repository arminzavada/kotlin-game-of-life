package com.triad.gol

import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
import javafx.scene.text.FontWeight
import tornadofx.*

class ApplicationStyle : Stylesheet() {
    companion object {
        val cellGrid by cssclass()
        val cellGridContainer by cssclass()
        val aliveCellClass by cssclass()
        val cellClass by cssclass()
        val icon by cssclass()
        val iconButton by cssclass()
        val title by cssid()
        val header by cssclass()
        val footer by cssclass()
        val controlPanel by cssclass()
        val controlPanelButtonsContainer by cssclass()
    }

    init {
        cellGrid {
            cellWidth = 20.px
            cellHeight = 20.px
            verticalCellSpacing = 1.px
            horizontalCellSpacing = 1.px
        }
        cellClass {
            backgroundColor += c("#cccccc")
        }
        aliveCellClass {
            backgroundColor += c("#0093ff")
        }
        title {
            fontSize = 2.em
            fontWeight = FontWeight.BOLD
            textFill = c("#0093ff")
            padding = box(0.px, 0.px, 10.px, 0.px)
            alignment = Pos.CENTER
        }
        iconButton {
            backgroundColor += c("transparent")

            and(pressed) {
                icon {
                    fill = c("#0093ff")
                }
            }

            and(selected) {
                icon {
                    fill = c("#0093ff")
                }
            }

            and(hover) {
                backgroundColor += c("#00000011")
            }
        }
        icon {
            fill = c("#8f8f8f")
        }
        controlPanel {
            backgroundColor += c("#d0d0d0")
            effect = DropShadow(10.0, c("#000000"))
            prefWidth = 250.px
            padding = box(10.px)
            spacing = 10.px

            star {
                spacing = 10.px
                alignment = Pos.CENTER
            }

            listView {
                backgroundColor += c("transparent")
                listCell {
                    backgroundColor += c("transparent")

                    and(hover) {
                        backgroundColor += c("#00000011")
                    }

                    and(selected) {
                        backgroundColor += c("#0093ff")
                    }
                }
            }
        }
    }
}