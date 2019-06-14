

// Multiple constructors

class  Person(private val name:String, private  val age:Int){

    // secondary constructors
    constructor(name:String, age:Int, job:String) : this(name, age)

    constructor(name:String, age:Int, job:String,location:String) : this(name, age)


    fun getAge() = age

    fun getName() = name
}


// data class

data class Person2(
    val name: String,
    var age: Int,
    var job: String = "",
    var location: String = ""
)