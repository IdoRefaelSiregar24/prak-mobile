package com.example.idoapps.pertemuan_2

fun main() {
    println("Hai rekan rekan...")
    println("Selamat datang di bahasa pemograman Kotlin")

    println("=================")

    var angka = 15
    println("Hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 1000
    val nilaiDouble = 100.003
    val nilaiFloat = 100.0f

    println("Nilai Integer = $nilaiInt")
    println("NilaiDouble = $nilaiDouble")
    println("NilaiFloat = $nilaiFloat")

    println("======= STRING =======")
    val huruf = 'a'
    println("Ini penggunaan karakter '$huruf'")

    val nilaiString = "MAWAR"
    println("Halo $nilaiString!\nApa Kabar?")

    println("======= Kondisi =======")

    val nilai = 10
    if (nilai<0){
        println("Bilangan negatif")
    }else {
        if (nilai%2 == 0){
            println("Bilangan genap")
        }else{
            println("Bilangan ganjil")
        }
    }
    println("========Perulangan=======")
    val kampusKu: Array<String> = arrayOf("Kampus", "Politeknik", "Caltex", "Riau")
    for (kampus: String in kampusKu){
        println(kampus)
    }
}