package uz.behzoddev.restaurantpos.data.worker

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.data.local.db.RestaurantDatabase
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.interactors.item.SaveAllFoodsInteractor
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class RestaurantWorker @WorkerInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
) : CoroutineWorker(context, workerParams) {


    @Inject
    lateinit var saveAllFoodsInteractor: SaveAllFoodsInteractor

    private val foodItems = listOf(
        FoodItem(
            "나이트로 바닐라 크림",
            "Nitro Vanilla Cream",
            "부드러운 목넘김의 나이트로 커피와 바닐라 크림의 매력을 한번에 느껴보세요!",
            2000,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002487]_20210426091745467.jpg",
            80,
            40,
            2,
            10,
            1,
            232,
            "우유"
        ),
        FoodItem(
            "나이트로 콜드 브루",
            "Nitro Cold Brew",
            "나이트로 커피 정통의 캐스케이딩과 부드러운 콜드 크레마!부드러운 목 넘김과 완벽한 밸런스에 커피 본연의 단맛을 경험할 수 있습니다.",
            2000,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000479]_20210426091844065.jpg",
            5,
            5,
            0,
            0,
            0,
            245,
            "우유"
        ),
        FoodItem(
            "돌체 콜드 브루",
            "Dolce Cold Brew",
            "무더운 여름철,동남아 휴가지에서 즐기는 커피를 떠오르게 하는 스타벅스 음료의 베스트 x 베스트 조합인 돌체 콜드 브루를 만 보세요!",
            2000,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002081]_20210415133657016.jpg",
            265,
            130,
            9,
            29,
            8,
            150,
            "우유"
        ),
        FoodItem(
            "미드나잇 베르가못 콜드 브루",
            "Midnight Bergamot Cold Brew",
            "화이트 초콜릿과 베르가못의 향이 콜드 브루와 조화되어 벚꽃이 만발한 보랏빛 밤을 닮은 콜드 브루 음료",
            2000,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000003273]_20220310085016371.jpg",
            170,
            40,
            13,
            29,
            3,
            135,
            "우유"
        ),
        FoodItem(
            "에스프레소 콘 파나",
            "Espresso Con Panna",
            "신선한 에스프레소 샷에 풍부한 휘핑크림을 얹은 커피 음료로서, 뜨거운 커피의 맛과 차갑고 달콤한 생크림의 맛을 같이 즐길 수 있는 커피 음료",
            2500,
            1,
            "에스프레소",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[30]_20210415144252425.jpg",
            30,
            0,
            15,
            1,
            0,
            75,
            "우유"
        ),
        FoodItem(
            "바닐라 크림 콜드 브루",
            "Vanilla Cream Cold Brew",
            "콜드 브루에 더해진 바닐라 크림으로 깔끔하면서 달콤한 콜드 브루를 새롭게 즐길 수 있는 음료입니다.",
            2500,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000487]_20210430112319174.jpg",
            125,
            58,
            6,
            11,
            3,
            150,
            "우유"
        ),
        FoodItem(
            "벨벳 다크 모카 나이트로",
            "Velvet Dark Mocha Nitro",
            "다크 초콜릿 모카의 진한 바디감과 함께\n" +
                    "헤이즐넛 향과 달콤한 카라멜 크림 폼으로\n" +
                    "벨벳같은 부드러움까지 살린 리저브 나이트로 커피",
            2500,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/03/[9200000003509]_20210322093452556.jpg",
            150,
            15,
            6,
            17,
            2,
            190,
            "우유"
        ),
        FoodItem(
            "제주 비자림 콜드 브루",
            "Jeju Forest Cold Brew",
            "제주 천년의 숲 비자림을 연상시키는 음료로 제주 유기농 말차와 콜드 브루가 조화로운 제주 특화 콜드 브루 음료",
            3000,
            1,
            "콜드브루 커피",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2022/03/[9200000002672]_20220311105512013.jpg",
            340,
            140,
            8,
            43,
            10,
            105,
            "우유"
        ),
        FoodItem(
            "에스프레소 마키아또",
            "Espresso Macchiato",
            "신선한 에스프레소 샷에 우유 거품을 살짝 얹은 커피 음료로써, 강렬한 에스프레소의 맛과 우유의 부드러움을 같이 즐길 수 있는 커피 음료",
            3000,
            1,
            "에스프레소",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[25]_20210415144211354.jpg",
            10,
            0,
            0,
            0,
            1,
            75,
            "우유"
        ),
        FoodItem(
            "카페 아메리카노",
            "Caffe Americano",
            "진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피",
            3200,
            1,
            "에스프레소",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[94]_20210430103337157.jpg",
            10,
            5,
            0,
            0,
            1,
            150,
            "없음"
        ),
        FoodItem(
            "카라멜 마키아또",
            "Caramel Macchiato",
            "향긋한 바닐라 시럽과 따뜻한 스팀 밀크 위에 풍성한 우유 거품을 얹고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료",
            3300,
            1,
            "에스프레소",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[126197]_20210415154610012.jpg",
            200,
            130,
            5,
            22,
            8,
            75,
            "대두/우유"
        ),
        FoodItem(
            "에스프레소",
            "Espresso",
            "스타벅스 에스프레소는 향기로운 크레마 층과 바디 층, 하트 층으로 이루어져 있으며, 입안 가득히 커피와 달콤한 카라멜 향이 느껴지는 커피 음료",
            3000,
            1,
            "에스프레소",
            "https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112850.jpg",
            5,
            0,
            0,
            0,
            0,
            75,
            "없음"
        ),

    )

    override suspend fun doWork() = coroutineScope {
        try {
            val database = RestaurantDatabase.invoke(applicationContext)
            database.getItemDao().saveAllFoods(foodItems)
            debug { "doWork method was called successfully" }
            Result.success()
        } catch (e: Exception) {
            debug {
                "doWork method was failed"
            }
            Result.failure()

        }
    }

    /*
    private fun fetchItemsFromRaw(): ArrayList<FoodItem> {
        val items = ArrayList<FoodItem>()
        val reader =
            BufferedReader(InputStreamReader(applicationContext.resources.openRawResource(R.raw.food_items)))
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

     */
}


