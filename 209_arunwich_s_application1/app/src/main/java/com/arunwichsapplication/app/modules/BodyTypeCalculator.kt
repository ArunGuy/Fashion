package com.arunwichsapplication.app.modules

data class Person(
    val height: Double,
    val weight: Double,
    val waist: Double,
    val bust: Double,
    val hip: Double,
    val gender: String,
    val bodyType: String // เพิ่ม property เพื่อเก็บข้อมูล body type
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
