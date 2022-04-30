package com.example.kotlinstudy

fun main() {
    helloWorld();
    println(add(1,2))
    println(valOrVar())

    //4.String Template
    var firstName = "진우"
    var lastName = "신"
    println("My Name Is ${ lastName + firstName } Hi")

    checkNumber(100)
}


//1. 함수

//리턴 타입이 없는 메소드
fun helloWorld() : Unit {
// Unit = void
    println("이게 머시여")
}

// 리턴타입이 있는 메소드
// 메소드명 ( 파라메터 변수명 : 파라메터 자료형 ) : 반환 할 자료형
fun add(a:Int,b:Int) : Int {
    return a+b;
}


// 2. val 과 var

// val == value 상수
// var == variable 변수

fun valOrVar() : Int {
    val a : Int = 10
    var b : Int = 9

    var c : String

    return a-b
}

//5. 조건식

fun max( a: Int , b : Int ) : Int {
    if ( a > b){
        return a
    } else {
        return b
    }
}

fun max2( a:Int, b:Int ) = if(a>b) a else b

fun checkNumber ( score : Int){
    when(score) {
        0 -> println("")
        1 -> println("")
        2 -> println("")
    }

    var b:Int = when(score){
        1->1
        2->2
        else ->3
    }

    when(score){
        in 90..100 ->println("Expert")
        in 10..90 -> println("Not Bad")
        else -> println("What Ever")
    }
}





