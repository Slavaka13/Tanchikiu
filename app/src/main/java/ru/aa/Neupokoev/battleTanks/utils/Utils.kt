package ru.aa.Neupokoev.battleTanks.utils

import android.view.View
import ru.aa.Neupokoev.battleTanks.CELL_SIZE
import ru.aa.Neupokoev.battleTanks.binding
import ru.aa.Neupokoev.battleTanks.models.Coordinate
import ru.aa.Neupokoev.battleTanks.models.Element

fun View.checkViewCanMoveThroughBorder(coordinate: Coordinate):Boolean{
    return coordinate.top >= 0 &&
            coordinate.top + this.height <= binding.container.height &&
            coordinate.left >= 0 &&
            coordinate.left + this.width <= binding.container.width
}

fun getElementByCoordinates(
    coordinate: Coordinate, elementsOnContainer: List<Element>
): Element? {
    for (element in elementsOnContainer) {
        for (height in 0 until element.height) {
            for (width in 0 until element.width) {
                val searchingCoordinate = Coordinate(
                    top = element.coordinate.top + height * CELL_SIZE,
                    left = element.coordinate.left + width * CELL_SIZE
                )
                if (coordinate == searchingCoordinate) {
                    return element
                }
            }
        }
    }
    return null
}
