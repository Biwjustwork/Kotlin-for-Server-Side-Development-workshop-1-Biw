package org.example

// 1. กำหนด data class สำหรับเก็บข้อมูลสินค้า
data class Product(val name: String, val price: Double, val category: String)

fun main() {
    // 2. สร้างรายการสินค้าตัวอย่าง (List<Product>)
    // สินค้า name = "Laptop", price = 35000.0, category = "Electronics"
    // สินค้า name = "Smartphone", price = 25000.0, category = "Electronics"
    // สินค้า name = "T-shirt", price = 450.0, category = "Apparel"
    // สินค้า name = "Monitor", price = 7500.0, category = "Electronics"
    // สินค้า name = "Keyboard", price = 499.0, category = "Electronics" // ราคาไม่เกิน 500
    // สินค้า name = "Jeans", price = 1200.0, category = "Apparel"
    // สินค้า name = "Headphones", price = 1800.0, category = "Electronics" // ตรงตามเงื่อนไข
//🚨    val products = ?
    val products = listOf(
        Product("Laptop", 35000.0, "Electronics"),
        Product("Smartphone", 25000.0, "Electronics"),
        Product("T-shirt",  450.0,  "Apparel"),
        Product("Monitor",  7500.0,  "Electronics"),
        Product("Keyboard", 499.0, "Electronics"),
        Product("Jeans", 1200.0, "Apparel"),
        Product("Headphones", 1800.0, "Electronics"))

    println("List of all products:")
//🚨    products.forEach { println(it) }
    products.forEach { println("${it.name}, ${it.price}, ${it.category}") }

    // --- โจทย์: จงหาผลรวมราคาสินค้าทั้งหมดในหมวด 'Electronics' ที่มีราคามากกว่า 500 บาท ---

    // 3. วิธีที่ 1: การใช้ Chaining กับ List โดยตรง
    // กรองสินค้าหมวด Electronics
    // กรองสินค้าที่ราคามากกว่า 500
    // ดึงเฉพาะราคาออกมาเป็น List<Double>
    // หาผลรวมของราคา
//🚨    val totalElecPriceOver500 = ?
    val totalElecPriceOver500 = products
        .filter { it.category == "Electronics" }
        .filter { it.price > 500 }
        .map { it.price }
        .sum()

    println("Method 1: Use Chaining with a List.")
//🚨    println("ผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท: $totalElecPriceOver500 บาท")
    println("The sum of the prices of electronics products > 500 baht: $totalElecPriceOver500 bath")

    // 4. (ขั้นสูง) วิธีที่ 2: การใช้ .asSequence() เพื่อเพิ่มประสิทธิภาพ
    // แปลง List เป็น Sequence ก่อนเริ่มประมวลผล
//🚨    val totalElecPriceOver500Sequence = ?
    val totalElecPriceOver500Sequence = products
        .asSequence()
        .filter { it.category == "Electronics" }
        .filter { it.price > 500 }
        .map { it.price }
        .sum()
    println("Method 2: Use .asSequence() (advanced)")
//🚨    println("ผลรวมราคาสินค้า Electronics ที่ราคา > 500 บาท: $totalElecPriceOver500Sequence บาท")
    println("The sum of the prices of electronics products > 500 baht: $totalElecPriceOver500Sequence bath")


    println("Discuss the differences between a List and a Sequence:")
    println("1. List Operations (method 1):")
    println("   - Each time an operation is called (such as filter, map), a new collection (list) is created to store the results of that step.")
    println("   - Example: First filter creates a new list -> second filter creates another new list -> map creates the final list -> sum executes.")
    println("   - It's suitable for small datasets because it's easy to understand. However, if the data is very large (millions of records), it will consume a lot of memory and time by creating new collections repeatedly.")
    println()
    println("2. Sequence Operations (method 2):")
    println("   - Use 'lazy' processing (only do this when you really need the results).")
    println("   - All operations (filter, map) will not work immediately. but will be lined up together")
    println("   - Each data element flows through the entire pipeline one piece at a time until the process is complete.")
    println("   - For example: 'Laptop' will be filtered by category -> filter by price -> map price, then 'Smartphone' will begin the same process.")
    println("   - No collections are created midway, saving memory and being much faster for large datasets because it works with data piece by piece and completes all steps in a single pass.")
    println("   - The calculation only occurs when a 'Terminal Operation' is called (in this case, .sum()).")
}