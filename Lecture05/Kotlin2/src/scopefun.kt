import java.lang.Exception
import javax.swing.plaf.basic.BasicTreeUI

data class Student(
    var id:Int,
    var name:String,
    var rollNo :Int,
    var feeStatus:Boolean=false,
    var marks:Int =0
)

data class School(
   var name: String,
   val students: MutableList<Student> = mutableListOf()
){
    fun addStudent(student: Student){
        students.add(student)
    }

    fun addFee(id:Int){
        val student = students.find { it.id == id}
        student?.feeStatus= true
    }
}

data class University(
    private val listOfSchools :MutableList<School> = mutableListOf()
){
    fun addSchool(school: School){
        listOfSchools.add(school)
    }

    fun showDataOfSchool(name: String){
        val school= listOfSchools.find { it.name == name }
        school?.students?.forEach { println(it) }
    }

    fun checkRecordsOfSchool(school: School){
        // checking records
    }

    fun getSchool(name:String) = listOfSchools.find { it.name == name } ?: throw Exception("School Not found")

    fun getHighestMarksStudent(school: School) = school.students.maxBy { it.marks }
}

fun main(){
    val university = University()

    val normalSchool = School("Normal")
    normalSchool.addStudent(Student(22,"Rohan",21))
    normalSchool.addStudent(Student(23,"Karandeep",22))
    normalSchool.addStudent(Student(24,"Manav",23))
    normalSchool.addStudent(Student(25,"gaurav",24))
    normalSchool.addStudent(Student(26,"Saurav",25))
    normalSchool.addStudent(Student(26,"Joseph",26))

    // use apply scope
    // when we need object itself plus we heavily need to use object's member function
    val cbSchool = School(name = "CB").apply {
        addStudent(Student(22,"Rohan",21))
        addStudent(Student(23,"Karandeep",22))
        addStudent(Student(24,"Manav",23))
        addStudent(Student(25,"gaurav",24))
        addStudent(Student(26,"Saurav",25))
        addStudent(Student(26,"Joseph",26))
    }


    val normalSchool2 = School("normal")
    university.addSchool(normalSchool2)
    university.showDataOfSchool(normalSchool2.name)
    university.checkRecordsOfSchool(normalSchool2)


    // use also scope - reduce scope to it
    // when we need object itself plus we also need to do some processing with object
    val smartSchool = School("Smart").also {
        university.addSchool(it)
        university.checkRecordsOfSchool(it)
        university.showDataOfSchool(it.name)
    }


    // Use with or run
    // when we want perform mostly with object but we want something else in result
    // we mostly performed with University's method but we were interested in student

    val achiever :Student?= university.run {
        val school = getSchool("cbSchool")
        checkRecordsOfSchool(school)
        showDataOfSchool(school.name)
        getHighestMarksStudent(school)
    }

    val achiever2:Student? = with(university){
        val school = getSchool("SmartSchool")
        checkRecordsOfSchool(school)
        showDataOfSchool(school.name)
        getHighestMarksStudent(school)
    }


    // All scope functions can be used with safe operator
    val nullSchool:School? = School("new")
    nullSchool?.let {
        university.showDataOfSchool(it.name)
        university.checkRecordsOfSchool(it)
    }

}