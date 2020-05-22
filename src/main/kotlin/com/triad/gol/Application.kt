package com.triad.gol

import com.triad.gol.views.MainMenuView
import tornadofx.*

class Application : App(MainMenuView::class, ApplicationStyle::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}