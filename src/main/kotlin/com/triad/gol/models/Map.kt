package com.triad.gol.models

import com.triad.gol.toInt

class Map(val width: Int, val height: Int) {
    val cells = Array(width * height) {
        Cell()
    }

    operator fun get(x: Int, y: Int): Boolean {
        return if (x in 0 until width && y in 0 until height) cells[y * width + x].isAlive
        else false
    }

    private fun countNeighbours(x: Int, y: Int): Int {
        return this[x - 1, y    ].toInt() +
            this[x + 1, y    ].toInt() +
            this[x - 1, y - 1].toInt() +
            this[x + 1, y - 1].toInt() +
            this[x - 1, y + 1].toInt() +
            this[x + 1, y + 1].toInt() +
            this[x    , y - 1].toInt() +
            this[x    , y + 1].toInt()
    }

    fun nextState() {
        cells.map {
            it.isAlive
        }.mapIndexed { index, value ->
            val y = index / width
            val x = index - y * width
            val neighbours = countNeighbours(x, y)

            when (value) {
                true -> neighbours in 2..3
                false -> neighbours == 3
            }
        }.forEachIndexed { index, value ->
            cells[index].isAlive = value
        }
    }
}