package org.example

// Workshop #1: Simple Console Application - Unit Converter

fun main() {
    // 2. ใช้ while (true) เพื่อให้โปรแกรมทำงานวนซ้ำ
    while (true) {
        // 1. แสดงเมนูให้ผู้ใช้เลือก
        println("===== Unit Converter =====")
        println("Please select the unit you wish to convert:")
        println("1. Celsius to Fahrenheit")
        println("2. Kilometers to Miles")
        println("Type 'exit' to exit the program.")
        print("Choose a menu option (1, 2, or exit): ")

        // 2. รับข้อมูลตัวเลือกจากผู้ใช้
        val choice = readln()

        // 3. ควบคุมการทำงานด้วย when expression
        // เลือก 1 เพื่อแปลง Celsius เป็น Fahrenheit: convertCelsiusToFahrenheit()
        // เลือก 2 เพื่อแปลง Kilometers เป็น Miles: convertKilometersToMiles()
        // เลือก 'exit' เพื่อออกจากโปรแกรม
        // 🚨

        if (choice == "1"){
            convertCelsiusToFahrenheit()
        }else if (choice == "2"){
            convertKilometersToMiles()
        }else if (choice == "exit"){
            break
        }


        println() // พิมพ์บรรทัดว่างเพื่อความสวยงาม
    }
}

// 4. สร้างฟังก์ชันแยกสำหรับการแปลงหน่วย Celsius to Fahrenheit: celsiusToFahrenheit
// สูตร celsius * 9.0 / 5.0 + 32
// 🚨

fun celsiusToFahrenheit(celsius: Double): Double{
    val fahrenheit: Double =  (celsius * 9.0/5.0) + 32.0
    return fahrenheit
}


// 4. สร้างฟังก์ชันแยกสำหรับการแปลงหน่วย Kilometers to Miles: kilometersToMiles
// สูตร kilometers * 0.621371
// 🚨

fun kilometersToMiles(kilometers: Double): Double{
    val miles: Double = kilometers * 0.621371
    return miles
}


// ฟังก์ชันสำหรับจัดการกระบวนการแปลง Celsius to Fahrenheit ทั้งหมด
fun convertCelsiusToFahrenheit() {
    print("Enter the value in Celsius: ")
    val input = readln()

    // 5. จัดการ Null Safety ด้วย toDoubleOrNull() และ Elvis operator (?:)
    // ออกจากฟังก์ชัน convertCelsiusToFahrenheit() หากข้อมูลผิดพลาด: return
    // celsius
    // 🚨
    val celsius: Double = input.toDoubleOrNull() ?: return


//🚨    val fahrenheitResult = celsiusToFahrenheit(celsius)
    val fahrenheitResult = celsiusToFahrenheit(celsius)

    // 6. แสดงผลลัพธ์
    // ใช้ String format เพื่อแสดงทศนิยม 2 ตำแหน่ง
//🚨    println("ผลลัพธ์: $celsius °C เท่ากับ ${"%.2f".format(fahrenheitResult)} °F")
    println("result: $celsius °C equal to ${"%.2f".format(fahrenheitResult)} °F")
}

// ฟังก์ชันสำหรับจัดการกระบวนการแปลง Kilometers to Miles ทั้งหมด
fun convertKilometersToMiles() {
    print("Enter the value in kilometers: ")
    val input = readln()

    // 5. จัดการ Null Safety ด้วย toDoubleOrNull() และ Elvis operator (?:)
    // ออกจากฟังก์ชัน convertKilometersToMiles() หากข้อมูลผิดพลาด: return
    // kilometers
    // 🚨
    val kilometers: Double = input.toDoubleOrNull() ?: return


//🚨    val milesResult = kilometersToMiles(kilometers)
    val milesResult = kilometersToMiles(kilometers)

    // 6. แสดงผลลัพธ์
//🚨    println("ผลลัพธ์: $kilometers km เท่ากับ ${"%.2f".format(milesResult)} miles")
    println("result: $kilometers km equal to ${"%.2f".format(milesResult)} miles")
}