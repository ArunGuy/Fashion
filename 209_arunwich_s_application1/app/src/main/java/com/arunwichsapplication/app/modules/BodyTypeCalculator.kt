package com.arunwichsapplication.app.modules

import kotlin.reflect.full.findAnnotation
data class Person(
    val height: Double,
    val weight: Double,
    val waist: Double,
    val bust: Double,
    val hip: Double,
    val gender: String,
    val bodyType: String
)

data class ClothingItem(
    val name: String,
    val suitableFor: String
)

class BodyTypeCalculator {
    fun calculateBodyType(person: Person): String {
        // แปลงค่าส่วนสูงจากเซนติเมตรเป็นเมตร
        val heightInMeter = person.height / 100.0
        // แปลงค่าน้ำหนักจากกิโลกรัมเป็นกิโลกรัม
        val weightInKg = person.weight
        // แปลงค่ารอบเอวจากนิ้วเป็นเซนติเมตร
        val waistInCm = person.waist * 2.54
        // แปลงค่ารอบอกจากนิ้วเป็นเซนติเมตร
        val bustInCm = person.bust * 2.54
        // แปลงค่ารอบสะโพกจากนิ้วเป็นเซนติเมตร
        val hipInCm = person.hip * 2.54

        val waistToHipRatio = waistInCm / hipInCm
        val bustToHipRatio = bustInCm / hipInCm

        return when {
            waistToHipRatio < 0.8 && bustToHipRatio >= 0.8 && bustToHipRatio <= 0.85 -> "Hourglass"
            waistToHipRatio >= 0.8 && bustToHipRatio >= 0.8 -> "Apple"
            waistToHipRatio < 0.8 && bustToHipRatio < 0.8 -> "Pear"
            waistToHipRatio >= 0.8 && bustToHipRatio < 0.8 -> "Rectangle"
            waistToHipRatio < 0.8 && bustToHipRatio > 0.85 -> "Inverted Triangle"
            bustToHipRatio <= 0.85 -> "Triangle" // เพิ่มเงื่อนไข Triangle Body Type
            waistToHipRatio >= 0.8 && bustToHipRatio <= 0.85 -> "Rectangle" // เพิ่มเงื่อนไข Rectangle Body Type
            waistToHipRatio < 0.8 && bustToHipRatio > 0.85 -> "Inverted Triangle" // เพิ่มเงื่อนไข Inverted Triangle Body Type
            waistToHipRatio > 0.85 && bustToHipRatio < 0.8 -> "Oval" // เพิ่มเงื่อนไข Oval Body Type
            waistToHipRatio < 0.8 && bustToHipRatio < 0.8 -> "Trapezoid" // เพิ่มเงื่อนไข Trapezoid Body Type
            else -> "Unknown"
        }
    }

    fun suggestClothing(person: Person, clothingItems: List<ClothingItem>): List<ClothingItem> {
        val suggestedClothing = mutableListOf<ClothingItem>()

        for (clothingItem in clothingItems) {
            if (clothingItem.suitableFor == person.bodyType) {
                suggestedClothing.add(clothingItem)
            }
        }

        return suggestedClothing
    }
}


// สร้างคลาสเพื่อเก็บข้อมูล Annotation จากโค้ดส่วนที่ 2
class AnnotationData {
    companion object {
        // เมธอดสำหรับดึงข้อมูล Annotation จากโค้ดส่วนที่ 2
        fun getBodyTypeClothingAnnotation(annotationClass: Class<*>): String? {
            // ใช้ reflection ในการหา Annotation ในคลาสที่ระบุ
            val annotation = annotationClass.kotlin.findAnnotation<Category>()
            // หากมี Annotation ให้คืนค่าชื่อของ body type ออกมา
            return annotation?.value
        }
    }
}

// ใช้งานคลาส AnnotationData เพื่อดึงข้อมูล Annotation จากโค้ดส่วนที่ 2
fun main() {
    // สร้างข้อมูลสำหรับผู้ใช้ (ตัวอย่างเท่านั้น)
    val user = Person(
        height = 165.0,
        weight = 60.0,
        waist = 75.0,
        bust = 90.0,
        hip = 95.0,
        gender = "Female",
        bodyType = "" // ค่านี้จะถูกคำนวณต่อไป
    )

    // สร้างอ็อบเจกต์ของ BodyTypeCalculator
    val bodyTypeCalculator = BodyTypeCalculator()

    // คำนวณ body type ของผู้ใช้
    val bodyType = bodyTypeCalculator.calculateBodyType(user)

    // แสดง body type ของผู้ใช้ที่คำนวณได้
    println("User's body type: $bodyType")

    // ดึงข้อมูล annotation ของเสื้อผ้าที่เหมาะสำหรับ body type ของผู้ใช้
    val suitableClothingAnnotation = when (bodyType) {
        "Hourglass" -> AnnotationData.getBodyTypeClothingAnnotation(HourglassBodyClothing::class.java)
        "Apple" -> AnnotationData.getBodyTypeClothingAnnotation(AppleBodyClothing::class.java)
        "Pear" -> AnnotationData.getBodyTypeClothingAnnotation(PearBodyClothing::class.java)
        "Rectangle" -> AnnotationData.getBodyTypeClothingAnnotation(RectangleBodyClothing::class.java)
        "Inverted Triangle" -> AnnotationData.getBodyTypeClothingAnnotation(InvertedTriangleBodyClothing::class.java)
        "Oval" -> AnnotationData.getBodyTypeClothingAnnotation(OvalBodyClothing::class.java)
        "Trapezoid" -> AnnotationData.getBodyTypeClothingAnnotation(TrapezoidBodyClothing::class.java)
        else -> null
    }




    // แสดงข้อมูลเสื้อผ้าที่เหมาะสำหรับ body type ของผู้ใช้ที่ดึงมาได้จาก annotation
    println("Clothing suitable for ${user.bodyType}: $suitableClothingAnnotation")
}
