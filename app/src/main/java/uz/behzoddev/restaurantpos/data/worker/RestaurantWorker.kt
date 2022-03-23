package uz.behzoddev.restaurantpos.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.interactors.item.SaveAllFoodsInteractor
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class RestaurantWorker @Inject constructor(
    context: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(context, workerParams) {

    @Inject
    lateinit var saveAllFoodsInteractor: SaveAllFoodsInteractor

    override suspend fun doWork() = coroutineScope {
        try {
            saveAllFoodsInteractor.invoke(fetchItemsFromRaw())
            debug { "doWork method was called successfully" }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    private fun fetchItemsFromRaw(): ArrayList<FoodItem> {
        val items = ArrayList<FoodItem>()
        val reader =
            BufferedReader(InputStreamReader(applicationContext.resources.openRawResource(R.raw.food_item)))
        var line = reader.readLine()
        var tokens: List<String>

        while (line != null) {
            tokens = line.split(",")

            try {
                items.add(
                    FoodItem(
                        tokens[0],
                        tokens[1],
                        tokens[2],
                        tokens[3].toLong(),
                        tokens[4].toInt(),
                        tokens[5],
                        tokens[6],
                        tokens[7].toInt(),
                        tokens[8].toInt(),
                        tokens[9].toInt(),
                        tokens[10].toInt(),
                        tokens[11].toInt(),
                        tokens[12].toInt(),
                        tokens[13]
                    )
                )
                debug { "The items.add() method was finished successfully" }
            } catch (e: NumberFormatException) {
                items.add(
                    FoodItem(
                        tokens[0],
                        tokens[1],
                        tokens[2],
                        0,
                        tokens[4].toInt(),
                        tokens[5],
                        tokens[6],
                        tokens[7].toInt(),
                        tokens[8].toInt(),
                        tokens[9].toInt(),
                        tokens[10].toInt(),
                        tokens[11].toInt(),
                        tokens[12].toInt(),
                        tokens[13]
                    )
                )
            }

            line = reader.readLine()
        }
        return items
    }
}