


// object oriented or state oriented way
fun doesSomething(list:List<Person>,age:Int):List<Person>{
    val newList = arrayListOf<Person>()
    for (item in list){
        if (item.getAge() <= age)
            newList.add(item)
    }
    return newList
}

// functional programming way
// easy and consice to understand
fun alsoDoesSomething(list: List<Person>,age: Int):List<Person>{
    return list.filter { it.getAge() <= age }
}


// lambda syntax
val lambdaFunction = { param:Int, param2:Double ->
    println("Param 1 $param")
    println("Param 2 $param2")

    // last line of lambda is treated as return type
    param2+param2
}


// Extension Function example
infix fun Int.percentOf(value: Int): Double {
    return (this / 100.0) * value
}


// Make your own High order function
fun List<Int>.filter(filterLogic:(Int)->Boolean):List<Int>{
    val newList = arrayListOf<Int>()
    for (item in this){
        // use of passed function
        if (filterLogic(item))
            newList.add(item)
    }
    return newList
}



data class Product(
    val id:Int,
    val name: String,
    var isDeliverd: Boolean,
    val price: Double
)

data class Shop(
    val name: String,
    val listOfproducts: MutableList<Product>
){
    fun getDeliveredMax(): Product {
        val deliverdList = listOfproducts.filter { product ->
            product.isDeliverd
        }
        val max = deliverdList.maxBy {
            it.price
        }
        return max ?: throw  Exception("Product not found")
    }

    fun getMaxProduct() = listOfproducts.maxBy { it.price }

    fun getDelivered() = listOfproducts.filter { it.isDeliverd }

    fun addItemToList(item:Product) = listOfproducts.add(item)
}

val shop = Shop(
    listOfproducts = mutableListOf(
        Product(1,"Android", false, 9000.0),
        Product(2,"Web", true, 10000.0),
        Product(3,"ML", true, 8000.0),
        Product(4,"Python", false, 9900.0),
        Product(5,"C++", false, 9780.0)
    ),
    name = "CB"
)

val list = listOf(
    Product(1,"Android", false, 9000.0),
    Product(2,"Web", true, 10000.0),
    Product(3,"ML", true, 8000.0),
    Product(4,"Python", false, 9900.0),
    Product(5,"C++", false, 9780.0)
)





































































