package uz.behzoddev.restaurantpos.common.extensions

import timber.log.Timber
import kotlin.math.log

/**
 * This extensions builds on Timber with an API that's easier to use from Kotlin.
 * Instead of using formatting parameters, you pass a lambda that is only evaluated
 * if the message is logged.
 */

/**
 * Extension function that wraps Timber's debug logging
 */
inline fun debug(t: Throwable? = null,message: () -> String) {
    return log { Timber.d(t,message())}
}

/**
 * Extension function that wraps Timber's info logging
 */
inline fun info(message: () -> String) {
    return log { Timber.i(message()) }
}

/**
 * Extension function that wraps Timber's error logging
 */
inline fun error(t: Throwable? = null, message: () -> String) {
    return log { Timber.e(t,message()) }
}


@PublishedApi
internal inline fun log(block: () -> Unit) {
    if (Timber.treeCount > 0) block()
}