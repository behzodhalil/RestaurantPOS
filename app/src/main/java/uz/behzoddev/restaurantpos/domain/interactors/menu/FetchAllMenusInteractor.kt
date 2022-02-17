package uz.behzoddev.restaurantpos.domain.interactors.menu

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

interface FetchAllMenusInteractor {
    operator fun invoke(): Flow<List<FoodMenu>>
}