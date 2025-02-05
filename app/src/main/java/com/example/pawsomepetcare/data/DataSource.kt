package com.example.pawsomepetcare.data

import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.model.News
import com.example.pawsomepetcare.model.Product
import com.example.pawsomepetcare.model.Service

//loads all the products to the data source
class DataSource {
    fun loadProducts(): List<Product> {
        return listOf<Product>(
            Product("1", R.string.royal_canine_puppy_food, R.string.royal_canine_puppy_price, R.string.royal_canine_puppy_desc, R.drawable.dog1),
            Product("2", R.string.black_hawk_puppy_food, R.string.black_hawk_puppy_price, R.string.black_hawk_puppy_desc, R.drawable.dog2),
            Product("3", R.string.black_hawk_adult_food, R.string.black_hawk_adult_price, R.string.black_hawk_adult_desc, R.drawable.dog3),
            Product("4", R.string.drools_puppy_food_combo, R.string.drools_puppy_combo_price, R.string.drools_puppy_combo_desc, R.drawable.dog4),
            Product("5", R.string.drools_adult_dog_food, R.string.drools_adult_food_price, R.string.drools_adult_food_desc, R.drawable.dog5),
            Product("6", R.string.beaphar_paste, R.string.beaphar_paste_price, R.string.beaphar_paste_desc, R.drawable.dog6),
            Product("7", R.string.beaphar_joint_tablets, R.string.beaphar_joint_tablets_price, R.string.beaphar_joint_tablets_desc, R.drawable.dog7),
            Product("8", R.string.water_dispenser, R.string.water_dispenser_price, R.string.water_dispenser_desc, R.drawable.dog8),
            Product("9", R.string.nutra_nuggets_cat_food, R.string.nutra_nuggets_cat_price, R.string.nutra_nuggets_cat_desc, R.drawable.cat1),
            Product("10", R.string.whiskas_kitten_food, R.string.whiskas_kitten_price, R.string.whiskas_kitten_desc, R.drawable.cat2),
            Product("11", R.string.drools_kitten_food, R.string.drools_kitten_price, R.string.drools_kitten_desc, R.drawable.cat3),
            Product("12", R.string.whiskas_combo_pack, R.string.whiskas_combo_price, R.string.whiskas_combo_desc, R.drawable.cat4),
            Product("13", R.string.whiskas_treats, R.string.whiskas_treats_price, R.string.whiskas_treats_desc, R.drawable.cat5),
            Product("14", R.string.whiskas_adult_cat_food, R.string.whiskas_adult_cat_price, R.string.whiskas_adult_cat_desc, R.drawable.cat6),
            Product("15", R.string.neutrals_cat_food, R.string.neutrals_cat_price, R.string.neutrals_cat_desc, R.drawable.cat7),
            Product("16", R.string.drools_cat_family_pack, R.string.drools_cat_family_price, R.string.drools_cat_family_desc, R.drawable.cat8),
            Product("17", R.string.black_hawk_cat_food, R.string.black_hawk_cat_price, R.string.black_hawk_cat_desc, R.drawable.cat9),
            Product("18", R.string.royal_canine_cat_food, R.string.royal_canine_cat_price, R.string.royal_canine_cat_desc, R.drawable.cat10),
            Product("19", R.string.small_cage, R.string.small_cage_price, R.string.small_cage_desc, R.drawable.cage1),
            Product("20", R.string.medium_cage, R.string.medium_cage_price, R.string.medium_cage_desc, R.drawable.cage2),
            Product("21", R.string.large_cage, R.string.large_cage_price, R.string.large_cage_desc, R.drawable.cage3),
            Product("22", R.string.gem_pharma_worms_out, R.string.gem_pharma_worms_out_price, R.string.gem_pharma_worms_out_desc, R.drawable.bird1),
            Product("23", R.string.gem_pharma_all_in_one, R.string.gem_pharma_all_in_one_price, R.string.gem_pharma_all_in_one_desc, R.drawable.bird2),
            Product("24", R.string.gem_pharma_respiratory, R.string.gem_pharma_respiratory_price, R.string.gem_pharma_respiratory_desc, R.drawable.bird3),
            Product("25", R.string.gem_pharma_multivitamin, R.string.gem_pharma_multivitamin_price, R.string.gem_pharma_multivitamin_desc, R.drawable.bird4)
        )
    }

    //licks out a random products from the data source
    fun loadFeaturedProducts(): List<Product> {
        val allProducts = loadProducts()
        return allProducts.shuffled().take(3)
    }

    //loads dog supplies from the products
    fun loadDogProducts(): List<Product> {
        val allProducts = loadProducts()
        return allProducts.filter { product ->
            product.id in listOf("1", "2", "3", "4", "5", "6", "7", "8")
        }
    }
    //loads cat supplies from the products
    fun loadCatProducts(): List<Product> {
        val allProducts = loadProducts()
        return allProducts.filter { product ->
            product.id in listOf("9", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20")
        }
    }
    //loads bird supplies from the products
    fun loadBirdProducts(): List<Product> {
        val allProducts = loadProducts()
        return allProducts.filter { product ->
            product.id in listOf( "22", "23", "24")
        }
    }
    //loads supplies from the products to the cart
    fun loadToCart():List<Product>{
        val cartProduct = loadProducts()
        return cartProduct.filter {
            product-> product.id  in listOf("10","1","4","5")
        }
    }
    //loads the services to the services page
    fun loadService():List<Service>{
        return listOf<Service>(
            Service("1",R.string.services_c_service_1,R.drawable.services_1),
            Service("2",R.string.services_c_service_2,R.drawable.services_2),
            Service("3",R.string.services_c_service_3,R.drawable.services_3),
            Service("4",R.string.services_c_service_4,R.drawable.services_4),
            Service("5",R.string.services_c_service_5,R.drawable.services_5),
            Service("6",R.string.services_c_service_6,R.drawable.services_6)
        )
    }

    //loads favourites to the page
    fun loadFavourites(): List<Product>{
        val allProducts = loadProducts()
        return allProducts.filter { product-> product.id in listOf("1","5","16")  }
    }

    //filters the data according to product it and feeds it to the master view
    fun getProductById(productId: String?): Product? {
        return loadProducts().find { it.id == productId }
    }
    //loads the news
    fun loadNews(): List<News> {
        return listOf<News>(
            News("1",
                R.string.our_new_store,
                R.string.openning,
                R.drawable.openning),
            News("2",
                R.string.grooming,
                R.string.grooming_1,
                R.drawable.newgrooming)
        )
    }


}
