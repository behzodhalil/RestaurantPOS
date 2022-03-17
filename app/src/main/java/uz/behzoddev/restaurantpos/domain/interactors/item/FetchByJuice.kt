package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface FetchByJuice {
    operator fun invoke(): Flow<List<FoodItem>>
}