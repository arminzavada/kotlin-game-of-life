package com.triad.gol

import javafx.geometry.Pos
import javafx.scene.effect.DropShadow
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
        cellGridContainer {
            backgroundColor += c("#7f7f7f")
        }
        cellGrid {
            cellWidth = 20.px
            cellHeight = 20.px
            verticalCellSpacing = 1.px
            horizontalCellSpacing = 1.px
        }
        cellClass {
            backgroundColor += c("#555")
        }
        aliveCellClass {
            backgroundColor += c("#333")
        }
        title {
            fontSize = 2.em
            textFill = c(175, 47, 47, 0.5)
            padding = box(0.px, 0.px, 10.px, 0.px)
        }
        iconButton {
            backgroundColor += c("transparent")

            and(hover) {
                icon {
                    fill = c("#af5b5e")
                }
            }

            and(pressed) {
                icon {
                    fill = c("#af2483")
                }
            }

            and(selected) {
                icon {
                    fill = c("#af2483")
                }
            }
        }
        icon {
            fill = c("#cc9a9a")
        }
        controlPanel {
            backgroundColor += c("#d3d3d3")
            effect = DropShadow(10.0, c("#000000"))
            prefWidth = 200.px
            padding = box(10.px)
            spacing = 10.px

            star {
                spacing = 10.px
                alignment = Pos.CENTER
            }
        }
    }
}