package uz.behzoddev.restaurantpos.common.local

// https://www.raywenderlich.com/23623842-object-in-kotlin-and-the-singleton-pattern
// https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android

object RoomContract {
    const val DATABASE_NAME = "restaurant_database"
    object FoodItemContract {
        const val FOOD_ITEM_TABLE = "food_item_table"
        const val FOOD_ITEM_ID = "food_item_id"
        const val FOOD_ITEM_NAME = "food_item_name"
        const val FOOD_ITEM_NAME_ENGLISH = "food_item_name_english"
        const val FOOD_ITEM_DESCRIPTION = "food_item_description"
        const val FOOD_ITEM_PRICE = "food_item_price"
        const val FOOD_ITEM_SUB_COUNT = "food_item_sub_count"
        const val FOOD_ITEM_TOTAL_COUNT = "food_item_total_count"
        const val FOOD_ITEM_CATEGORY = "food_item_category"
        const val FOOD_ITEM_PHOTO = "food_item_photo"
        const val FOOD_ITEM_PAID = "food_item_is_paid"
        const val FOOD_ITEM_SERVING_SIZE = "food_item_serving_size"
        const val FOOD_ITEM_SODIUM = "food_item_sodium"
        const val FOOD_ITEM_SATURATED_FAT = "food_item_saturated_fat"
        const val FOOD_ITEM_SUGAR = "food_item_sugar"
        const val FOOD_ITEM_PROTEIN = "food_item_protein"
        const val FOOD_ITEM_CAFFEINE = "food_item_caffeine"
        const val FOOD_ITEM_ALLERGENS = "food_item_allergens"
    }
    object FoodMenuContract {
        const val FOOD_MENU_TABLE = "food_menu_table"
        const val FOOD_MENU_ID = "food_menu_id"
        const val FOOD_MENU_NAME = "food_menu_name"
        const val FOOD_MENU_DESC_NAME = "food_menu_desc"
    }
    object FoodStoreContract {
        const val FOOD_STORE_TABLE = "food_store_table"
        const val FOOD_STORE_BRANCH_NAME = "food_store_branch_name"
        const val FOOD_STORE_OWNER_NAME = "food_store_owner_name"
        const val FOOD_STORE_PHONE_NUMBER = "food_store_phone_number"
        const val FOOD_STORE_ADDRESS = "food_store_address"
        const val FOOD_STORE_ID = "food_store_id"
    }
    object FoodPasswordContract {
        const val FOOD_PASSWORD_TABLE = "food_password_table"
        const val FOOD_PASSWORD_ID = "food_password_id"
        const val FOOD_PASSWORD = "food_password"
    }
}