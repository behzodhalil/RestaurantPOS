package uz.behzoddev.restaurantpos.common.extensions

import timber.log.Timber
import kotlin.math.log

/**
 * Extension function that wraps Timber's debug logging
 */
internal fun debug(message:String) { Timber.d(message) }

/**
 * Extension function that wraps Timber's info logging
 */
internal fun info(message: String) { Timber.i(message)}
