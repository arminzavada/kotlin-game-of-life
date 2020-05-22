package com.triad.gol

import tornadofx.*

class ApplicationStyle : Stylesheet() {
    companion object {
        val aliveCell by cssclass()
    }

    init {
        button {
            backgroundColor += c("#ffffff")
        }
        aliveCell {
            backgroundColor += c("#000000")
        }
    }
}