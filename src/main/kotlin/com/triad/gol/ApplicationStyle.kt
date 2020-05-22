package com.triad.gol

import tornadofx.*

class ApplicationStyle : Stylesheet() {
    companion object {
        val cellGrid by cssclass()
        val aliveCellClass by cssclass()
        val cellClass by cssclass()
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
    }
}