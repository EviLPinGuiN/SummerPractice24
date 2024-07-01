package ru.itis.summerpractice24.day1

import android.util.Log

fun main() {
    val arrayExampleKotlin = arrayOf(1, 2, 3, 4)

//    val list2 = ArrayList<Int>(initialCapacity = 15)

    val list = listOf(1, 2, 3, 4)
    val listA = arrayListOf(1, 2, 3)
    val listM = mutableListOf(1, 2, 3)

    for (element in 0..10 step 5) {

    }

    list.forEachIndexed { index, element ->
        print("Index: $element")
    }

    list.forEach { element ->

        print("Index: $element")
    }

    // ctrl+alt+L
    // cmd+opt+L

    val newList: List<String> = list
        .filter {
            it > 5
        }
        .map {
            "New value = $it"
        }


}

fun test2() {

    val userData = listOf(
        UserDataSecond(id = 1, address = "iudicabit", phone = "(720) 107-2917"),
        UserDataSecond(id = 2, address = "asdas", phone = "(720) 108-2917"),
        UserDataSecond(id = 3, address = "213123", phone = "(720) 101-2917"),
        UserDataSecond(id = 4, address = "sadsadx", phone = "(720) 102-2917"),
        UserDataSecond(id = 5, address = "vbb gf", phone = "(720) 103-2917"),
        UserDataSecond(id = 6, address = "wqewqe", phone = "(720) 100-2917"),
    )


    try {
        val result = userData.last {
            it.phone == "123-213"
        }

        userData.sortedWith(compareBy<UserDataSecond> {
            it.id
        }.thenByDescending {
            it.address.length
        }.thenByDescending {
            it.phone?.length
        })
    } catch (ex1: NoSuchElementException) {

    } catch (ex: RuntimeException) {

    } finally {
        print("asdaswd")
    }


    val map: Map<Int, UserDataSecond> = userData.associateBy {
        it.id
    }


    val map2 = mapOf(
        Pair(
            first = 5911,
            second = UserDataSecond(id = 5911, address = "sit", phone = null)
        ),

        5912 to UserDataSecond(id = 5912, address = "sit", phone = null),
        5912 to UserDataSecond(id = 5912, address = "sit", phone = null),
    )
    val map3 = mutableMapOf(
        3 to "asdasda"
    )
    val valH = hashMapOf(1 to "asddsad")

    map3.put(4, "asdas")
    map3 += mapOf(5 to "asdasd")

    map.getOrElse(3) {

        UserDataSecond(id = 3, address = "asdasd", phone = "1121")
    }

    map.forEach { key, value ->
        Log.e("TAG", "MSG $key, $value")
    }

    map.getOrDefault(
        key = 3,
        defaultValue = UserDataSecond(id = 3, address = "asdasd", phone = "1121")
    )
}

fun testWhenReturnDesc(month: Month): String {
    return when (month) {
        Month.Jan -> "Now jan: ${month.code}"
        Month.Feb -> "Now feb: ${month.code}"
        Month.March -> "Now march: ${month.code}"
        Month.Apr -> ""
    }
}

fun whenExample(color: String) {
    if (color.isEmpty())
        println("IS EMPTY")
    else if (color.length < 10 || color.contains("green")) {
        println("IS EMPTY")
    } else {
        "asdasd"
    }

    if (color.isEmpty())
        println("IS EMPTY")
    else {
        color.length
    }

    when {
        color.isEmpty() -> println("IS EMPTY")
        else -> color.length
    }

    when {
        color.isEmpty() -> println("IS EMPTY")
        color.length < 10 || color.contains("green") -> println("IS EMPTY")
        else -> {
            "asdasd"
        }
    }
}

enum class Month(val code: Int) {
    Jan(11), Feb(22), March(33), Apr(44);
}

fun appendString(arg1: String, arg2: String, userDataSecond: UserDataSecond): String? {
    return userDataSecond.phone?.let { safePhone ->
        println("UserPhone: $safePhone")
        "userDataSecond.address;$safePhone"
    }
//
//    return if (userDataSecond.phone != null) {
//        println("UserPhone: ${userDataSecond.phone}")
//        "userDataSecond.address;${userDataSecond.phone}"
//    } else {
//        ""
//    }
}

fun testFun(userPhone: String): String {
    println("UserPhone: $userPhone")
    return userPhone
}

open class User(
    open val name: String,
    var age: Int,
    val userData: UserData,
    email: String,
) {

    private var userInfo: String = ""

    init {
        userInfo = "$name;${age * 10};$email;${userData.address}" //
    }

    companion object {
        // final static String sampleValue = new String("sad")
        const val sampleValue = "sad"
    }
}

class UserData(
    val address: String,
    val phone: String,
)

data class UserDataSecond(
    val id: Int,
    val address: String = "sampleUserAddress",
    val phone: String?,
)

class EmailUser(
    override val name: String,
    age: Int,
    userData: UserData,
    email: String,
) : User(
    name = name,
    age = age,
    userData = userData,
    email = email,
), UserAction, EmailAction, PhoneAction {

    override fun doSomething() {
        println("Result action")
    }
}

interface UserAction {

    fun doSomething()
}

interface EmailAction

interface PhoneAction

