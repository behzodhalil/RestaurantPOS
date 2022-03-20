package uz.behzoddev.restaurantpos.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/*
 * A main interface that manages Coroutine context.This class also provides a crucial benefit for
 * testing
 */
interface DispatcherProviders {

    /**
     * Dispatcher definition for Dispatchers.MAIN
     */
    val main: CoroutineDispatcher

    /**
     * Dispatcher definition for Dispatchers.IO
     */
    val io: CoroutineDispatcher

    /**
     * Dispatcher definition for Dispatchers.Default
     */
    val default: CoroutineDispatcher

    /**
     * Dispatcher definition for Dispatchers.Unconfined
     */
    val unconfined: CoroutineDispatcher
}