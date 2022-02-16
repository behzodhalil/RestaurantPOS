package uz.behzoddev.restaurantpos.common.extensions

import timber.log.Timber
import kotlin.math.log

// https://github.com/ajalt/timberkt

/**
 * Extension function that wraps Timber's debug logging
 */
inline fun debug(t: Throwable? = null,message: () -> String) = log { Timber.d(t,message()) }

/**
 * Extension function that wraps Timber's info logging
 */
inline fun info(message: () -> String) = log { Timber.i(message()) }


@PublishedApi
internal inline fun log(block: () -> Unit) {
    if (Timber.treeCount > 0) block()
}