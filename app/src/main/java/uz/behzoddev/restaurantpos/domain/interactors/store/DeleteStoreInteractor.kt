package uz.behzoddev.restaurantpos.domain.interactors.store

import uz.behzoddev.restaurantpos.data.local.models.FoodStore

interface DeleteStoreInteractor {
    suspend operator fun invoke(foodStore: FoodStore): Long
}