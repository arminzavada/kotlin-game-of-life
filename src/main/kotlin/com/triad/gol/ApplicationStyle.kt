package com.triad.gol

import javafx.geometry.Pos
import tornadofx.*

class ApplicationStyle : Stylesheet() {
    companion object {
        val cellGrid by cssclass()
        val aliveCellClass by cssclass()
        val cellClass by cssclass()
        val icon by cssclass()
        val iconButton by cssclass()
        val title by cssid()
        val header by cssclass()
        val footer by cssclass()
    }

    init {
        cellGrid {
            backgroundColor += c("#000")
        }
        cellClass {
            backgroundColor += c("#555")
        }
        aliveCellClass {
            backgroundColor += c("#333")
        }
        title {
            fontSize = 3.em
            textFill = c(175, 47, 47, 0.5)
        }
        header {
            alignment = Pos.CENTER
            star {
                alignment = Pos.CENTER_LEFT
            }
        }
        footer {
            padding = box(10.px)
            alignment = Pos.CENTER
            spacing = 20.px
            star {
                spacing = 10.px
            }
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
    }
}