package uz.behzoddev.restaurantpos.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Coroutine dispatchers implementation for Dispatchers. Process will be started inside
 * the specified thread by this class.
 */
class DispatcherProvidersImpl : DispatcherProviders {

    /**
     * Binds with Dispatchers.Main by default.
     */
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    /**
     * Binds with Dispatchers.IO by default.
     */
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    /**
     * Binds with Dispatchers.Default by default.
     */
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    /**
     * Binds with Dispatchers.Unconfined by default.
     */
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}