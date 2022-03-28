package uz.behzoddev.restaurantpos.domain.interactors.order

interface DeleteAllOrdersInteractor {
    suspend operator fun invoke()
}