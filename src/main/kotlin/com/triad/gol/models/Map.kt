package com.triad.gol.models

fun Boolean.binary() = if(this) 1 else 0

class Map(val width: Int, val height: Int) {
    val cells = Array(width * height) {
        Cell()
    }

    operator fun get(x: Int, y: Int): Boolean {
        return if (x in 0 until width && y in 0 until height) cells[y * width + x].isAlive
        else false
    }

    fun nextState() {
        cells.map {
            it.isAlive
        }.mapIndexed { index, value ->
            val y = index / width
            val x = index - y * width

            val neighbours =
                this[x - 1, y    ].binary() +
                this[x + 1, y    ].binary() +
                this[x - 1, y - 1].binary() +
                this[x + 1, y - 1].binary() +
                this[x - 1, y + 1].binary() +
                this[x + 1, y + 1].binary() +
                this[x    , y - 1].binary() +
                this[x    , y + 1].binary()

            when (value) {
                true -> neighbours in 2..3
                false -> neighbours == 3
            }
        }.forEachIndexed { index, value ->
            cells[index].isAlive = value
        }
    }
}