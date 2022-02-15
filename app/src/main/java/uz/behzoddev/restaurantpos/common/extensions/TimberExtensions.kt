package uz.behzoddev.restaurantpos.common.extensions

import timber.log.Timber

fun debugging(debug: String) {
    return Timber.d(debug)
}