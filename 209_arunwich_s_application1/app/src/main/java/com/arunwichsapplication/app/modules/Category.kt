package com.arunwichsapplication.app.modules

@Retention(AnnotationRetention.RUNTIME)
annotation class Category(val value: String)

// เสื้อผ้าสำหรับรูปร่างแพร์
@Category("Pear Body")
annotation class PearBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างโอวัล
@Category("Oval Body")
annotation class OvalBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างรูปปลาทู
@Category("Trapezoid Body")
annotation class TrapezoidBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างสามเหลี่ยมคว่ำ
@Category("Inverted Triangle Body")
annotation class InvertedTriangleBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างลูกแอปเปิ้ล
@Category("Apple Body")
annotation class AppleBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างนาฬิกาทราย
@Category("Hourglass Body")
annotation class HourglassBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เสื้อผ้าสำหรับรูปร่างสี่เหลี่ยมผืนผ้า
@Category("Rectangle Body")
annotation class RectangleBodyClothing(
    val nameThai: String,
    val nameEnglish: String
)

// เดรสทรง A-line ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "เดรสทรง A-line",
    nameEnglish = "A-line Dress"
)
@HourglassBodyClothing(
    nameThai = "เดรสทรง A-line",
    nameEnglish = "A-line Dress"
)
@InvertedTriangleBodyClothing(
    nameThai = "เดรสทรง A-line",
    nameEnglish = "A-line Dress"
)
annotation class ALineDress

// เดรสที่มีขนาดพอดีรูปร่างแต่ไม่รัดรูปจนเกินไป ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "เดรสที่มีขนาดพอดีรูปร่างแต่ไม่รัดรูปจนเกินไป",
    nameEnglish = "Fitted Dress"
)
@HourglassBodyClothing(
    nameThai = "เดรสที่มีขนาดพอดีรูปร่างแต่ไม่รัดรูปจนเกินไป",
    nameEnglish = "Fitted Dress"
)
@InvertedTriangleBodyClothing(
    nameThai = "เดรสที่มีขนาดพอดีรูปร่างแต่ไม่รัดรูปจนเกินไป",
    nameEnglish = "Fitted Dress"
)
annotation class FittedDress

// เสื้อที่มีคอ V ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "เสื้อที่มีคอ V",
    nameEnglish = "V-neck Top"
)
@HourglassBodyClothing(
    nameThai = "เสื้อที่มีคอ V",
    nameEnglish = "V-neck Top"
)
@InvertedTriangleBodyClothing(
    nameThai = "เสื้อที่มีคอ V",
    nameEnglish = "V-neck Top"
)
annotation class VNeckTop

// เสื้อที่มีคอกลมลึก ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "เสื้อที่มีคอกลมลึก",
    nameEnglish = "Deep Round Neck Top"
)
@HourglassBodyClothing(
    nameThai = "เสื้อที่มีคอกลมลึก",
    nameEnglish = "Deep Round Neck Top"
)
@InvertedTriangleBodyClothing(
    nameThai = "เสื้อที่มีคอกลมลึก",
    nameEnglish = "Deep Round Neck Top"
)
annotation class DeepRoundNeckTop

// สร้อยคอที่มีความยาวมาถึงด้านบนของหน้าอก ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "สร้อยคอที่มีความยาวมาถึงด้านบนของหน้าอก",
    nameEnglish = "Statement Necklace"
)
@HourglassBodyClothing(
    nameThai = "สร้อยคอที่มีความยาวมาถึงด้านบนของหน้าอก",
    nameEnglish = "Statement Necklace"
)
@InvertedTriangleBodyClothing(
    nameThai = "สร้อยคอที่มีความยาวมาถึงด้านบนของหน้าอก",
    nameEnglish = "Statement Necklace"
)
annotation class StatementNecklace

// เดรสสั้น ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "เดรสสั้น",
    nameEnglish = "Short Dress"
)
@HourglassBodyClothing(
    nameThai = "เดรสสั้น",
    nameEnglish = "Short Dress"
)
@InvertedTriangleBodyClothing(
    nameThai = "เดรสสั้น",
    nameEnglish = "Short Dress"
)
annotation class ShortDress

// แจ็คเก็ตที่มีไหล่ที่ชัดเจน ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "แจ็คเก็ตที่มีไหล่ที่ชัดเจน",
    nameEnglish = "Structured Jacket"
)
@HourglassBodyClothing(
    nameThai = "แจ็คเก็ตที่มีไหล่ที่ชัดเจน",
    nameEnglish = "Structured Jacket"
)
@InvertedTriangleBodyClothing(
    nameThai = "แจ็คเก็ตที่มีไหล่ที่ชัดเจน",
    nameEnglish = "Structured Jacket"
)
annotation class StructuredJacket

// กางเกงยีนส์ที่มีกระเป๋าด้านหลัง ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "กางเกงยีนส์ที่มีกระเป๋าด้านหลัง",
    nameEnglish = "Low Rise Jeans"
)
@HourglassBodyClothing(
    nameThai = "กางเกงยีนส์ที่มีกระเป๋าด้านหลัง",
    nameEnglish = "Low Rise Jeans"
)
@InvertedTriangleBodyClothing(
    nameThai = "กางเกงยีนส์ที่มีกระเป๋าด้านหลัง",
    nameEnglish = "Low Rise Jeans"
)
annotation class LowRiseJeans

// กางเกงยีนส์ทรงต่ำ ที่เหมาะสำหรับ Apple Body, Hourglass Body, Inverted Triangle Body
@AppleBodyClothing(
    nameThai = "กางเกงยีนส์ทรงต่ำ",
    nameEnglish = "Bootcut Jeans"
)
@HourglassBodyClothing(
    nameThai = "กางเกงยีนส์ทรงต่ำ",
    nameEnglish = "Bootcut Jeans"
)
@InvertedTriangleBodyClothing(
    nameThai = "กางเกงยีนส์ทรงต่ำ",
    nameEnglish = "Bootcut Jeans"
)
annotation class BootcutJeans

// กางเกงยีนส์สกินนี่ ที่เหมาะสำหรับ Hourglass Body, Inverted Triangle Body
@HourglassBodyClothing(
    nameThai = "กางเกงยีนส์สกินนี่",
    nameEnglish = "Skinny Jeans"
)
@InvertedTriangleBodyClothing(
    nameThai = "กางเกงยีนส์สกินนี่",
    nameEnglish = "Skinny Jeans"
)
annotation class SkinnyJeans

// กระโปรงแบบดินสอ ที่เหมาะสำหรับ Hourglass Body, Inverted Triangle Body
@HourglassBodyClothing(
    nameThai = "กระโปรงแบบดินสอ",
    nameEnglish = "Pencil Skirt"
)
@InvertedTriangleBodyClothing(
    nameThai = "กระโปรงแบบดินสอ",
    nameEnglish = "Pencil Skirt"
)
annotation class PencilSkirt

// เดรสที่เน้นสีเอว ที่เหมาะสำหรับ Hourglass Body, Apple Body, Inverted Triangle Body
@HourglassBodyClothing(
    nameThai = "เดรสที่เน้นสีเอว",
    nameEnglish = "Waist Emphasizing Dress"
)
@AppleBodyClothing(
    nameThai = "เดรสที่เน้นสีเอว",
    nameEnglish = "Waist Emphasizing Dress"
)
@InvertedTriangleBodyClothing(
    nameThai = "เดรสที่เน้นสีเอว",
    nameEnglish = "Waist Emphasizing Dress"
)
annotation class WaistEmphasizingDress

// กระโปรงเอวสูง ที่เหมาะสำหรับ Hourglass Body, Apple Body, Inverted Triangle Body
@HourglassBodyClothing(
    nameThai = "กระโปรงเอวสูง",
    nameEnglish = "High Waisted Skirt"
)
@AppleBodyClothing(
    nameThai = "กระโปรงเอวสูง",
    nameEnglish = "High Waisted Skirt"
)
@InvertedTriangleBodyClothing(
    nameThai = "กระโปรงเอวสูง",
    nameEnglish = "High Waisted Skirt"
)
annotation class HighWaistedSkirt

// เสื้อผ้าฝรั่ง
@RectangleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Wear")
@AppleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Wear")
@HourglassBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Wear")
@InvertedTriangleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Wear")
annotation class WesternWear

// เสื้อพรีพ
@RectangleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Shirt")
@AppleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Shirt")
@HourglassBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Shirt")
annotation class PreppyShirt

// เสื้อเซติน
@RectangleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Shirt")
@AppleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Shirt")
@HourglassBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Shirt")
annotation class SatinShirt

// เสื้อไหมพรม
@RectangleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Shirt")
@AppleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Shirt")
@HourglassBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Shirt")
annotation class SilkShirt



// เสื้อยูนิฟอร์ม
@RectangleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform Shirt")
@AppleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform Shirt")
@HourglassBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform Shirt")
annotation class UniformShirt




// เสื้อผ้าทำงาน
@RectangleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Work Shirt")
@AppleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Work Shirt")
@HourglassBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Work Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Work Shirt")
annotation class WorkShirt



// กางเกงออกกำลังกาย
@RectangleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Workout Pants")
@AppleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Workout Pants")
@HourglassBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Workout Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Workout Pants")
annotation class WorkoutPants


// กางเกงโยคะ
@RectangleBodyClothing(nameThai = "กางเกงโยคะ", nameEnglish = "Yoga Pants")
@AppleBodyClothing(nameThai = "กางเกงโยคะ", nameEnglish = "Yoga Pants")
@HourglassBodyClothing(nameThai = "กางเกงโยคะ", nameEnglish = "Yoga Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงโยคะ", nameEnglish = "Yoga Pants")
annotation class YogaPants

// กางเกงร้อน
@RectangleBodyClothing(nameThai = "กางเกงร้อน", nameEnglish = "Shorts")
@AppleBodyClothing(nameThai = "กางเกงร้อน", nameEnglish = "Shorts")
@HourglassBodyClothing(nameThai = "กางเกงร้อน", nameEnglish = "Shorts")
@InvertedTriangleBodyClothing(nameThai = "กางเกงร้อน", nameEnglish = "Shorts")
annotation class Shorts

// กางเกงยีนส์แฟชั่น
@RectangleBodyClothing(nameThai = "กางเกงยีนส์แฟชั่น", nameEnglish = "Fashion Jeans")
@AppleBodyClothing(nameThai = "กางเกงยีนส์แฟชั่น", nameEnglish = "Fashion Jeans")
@HourglassBodyClothing(nameThai = "กางเกงยีนส์แฟชั่น", nameEnglish = "Fashion Jeans")
@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์แฟชั่น", nameEnglish = "Fashion Jeans")
annotation class FashionJeans

// กางเกงวอร์มขากว้าง
@RectangleBodyClothing(nameThai = "กางเกงวอร์มขากว้าง", nameEnglish = "Wide-Leg Pants")
@PearBodyClothing(nameThai = "กางเกงวอร์มขากว้าง", nameEnglish = "Wide-Leg Pants")
annotation class WideLegPants

// กางเกงขากระบอก
@RectangleBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@AppleBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@HourglassBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@OvalBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@TrapezoidBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
@PearBodyClothing(nameThai = "กางเกงขากระบอก", nameEnglish = "Bootcut Pants")
annotation class BootcutPants

// กางเกงวอร์มขาจั๊ม
@RectangleBodyClothing(nameThai = "กางเกงวอร์มขาจั๊ม", nameEnglish = "Wide-Leg Shorts")
@PearBodyClothing(nameThai = "กางเกงวอร์มขาจั๊ม", nameEnglish = "Wide-Leg Shorts")
annotation class WideLegShorts

// ผ้าเรยอนแบบบาง
@Category("Thin Fabric")
annotation class ThinFabric

// กางเกงเทเลอร์
@ThinFabric
@RectangleBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@AppleBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@HourglassBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@OvalBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@TrapezoidBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
@PearBodyClothing(nameThai = "กางเกงเทเลอร์", nameEnglish = "Tailored Pants")
annotation class TailoredPants

// กางเกงแบบหลวม (baggy)
@Category("Baggy Style")
annotation class BaggyStyle

@BaggyStyle
@RectangleBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@AppleBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@HourglassBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@OvalBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@TrapezoidBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
@PearBodyClothing(nameThai = "กางเกงแบบหลวม", nameEnglish = "Baggy Pants")
annotation class BaggyPants

// กางเกงผู้ชายไซส์ใหญ่ สไตล์ฮิปฮอป
@Category("Hip Hop Style")
annotation class HipHopStyle

@HipHopStyle
@RectangleBodyClothing(nameThai = "กางเกงคาร์โก้", nameEnglish = "Cargo Pants")
@PearBodyClothing(nameThai = "กางเกงคาร์โก้", nameEnglish = "Cargo Pants")
annotation class CargoPants

@HipHopStyle
@AppleBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@RectangleBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@HourglassBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@InvertedTriangleBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@OvalBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@TrapezoidBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
@PearBodyClothing(nameThai = "กางเกงจ็อกเกอร์", nameEnglish = "Joggers")
annotation class Joggers

@Category("Straight Leg Style")
annotation class StraightLegStyle

@StraightLegStyle
@RectangleBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@AppleBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@HourglassBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@OvalBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@TrapezoidBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
@PearBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Pants")
annotation class StraightLegPants

// เสื้อยืด
@RectangleBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@AppleBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@HourglassBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@OvalBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
@PearBodyClothing(nameThai = "เสื้อยืดลำลอง", nameEnglish = "Longline T-shirt")
annotation class LonglineTShirt

// เสื้อ T-shirt คอกลม
@RectangleBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@AppleBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@HourglassBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@OvalBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
@PearBodyClothing(nameThai = "เสื้อยืดคอกลม", nameEnglish = "Round Neck T-shirt")
annotation class RoundNeckTShirt

// เสื้อเกราะ
@RectangleBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@AppleBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@HourglassBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@OvalBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
@PearBodyClothing(nameThai = "เสื้อเกราะ", nameEnglish = "Armor Shirt")
annotation class ArmorShirt

// เสื้อคลุมกันน้ำ
@RectangleBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@AppleBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@HourglassBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@InvertedTriangleBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@OvalBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@TrapezoidBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
@PearBodyClothing(nameThai = "เสื้อคลุมกันน้ำ", nameEnglish = "Raincoat")
annotation class Raincoat

// เสื้อโค้ท
@RectangleBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@AppleBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@HourglassBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@InvertedTriangleBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@OvalBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@TrapezoidBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
@PearBodyClothing(nameThai = "เสื้อโค้ท", nameEnglish = "Coat")
annotation class Coat

// เสื้อโลโซ่
@RectangleBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@AppleBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@HourglassBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@OvalBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
@PearBodyClothing(nameThai = "เสื้อโลโซ่", nameEnglish = "Polo Shirt")
annotation class PoloShirt

// เสื้อโท๊ป
@RectangleBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@AppleBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@HourglassBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@InvertedTriangleBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@OvalBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@TrapezoidBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
@PearBodyClothing(nameThai = "เสื้อโท๊ป", nameEnglish = "Top")
annotation class Top

// เสื้อฮูดี้
@RectangleBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@AppleBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@HourglassBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@InvertedTriangleBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@OvalBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@TrapezoidBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
@PearBodyClothing(nameThai = "เสื้อฮูดี้", nameEnglish = "Hoodie")
annotation class Hoodie

// เสื้อผ้าฝรั่ง
@RectangleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@AppleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@HourglassBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@InvertedTriangleBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@OvalBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@TrapezoidBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
@PearBodyClothing(nameThai = "เสื้อผ้าฝรั่ง", nameEnglish = "Western Clothing")
annotation class WesternClothing

// เสื้อพรีพ
@RectangleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@AppleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@HourglassBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@InvertedTriangleBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@OvalBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@TrapezoidBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
@PearBodyClothing(nameThai = "เสื้อพรีพ", nameEnglish = "Preppy Clothing")
annotation class PreppyClothing

// เสื้อเซติน
@RectangleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@AppleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@HourglassBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@InvertedTriangleBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@OvalBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@TrapezoidBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
@PearBodyClothing(nameThai = "เสื้อเซติน", nameEnglish = "Satin Clothing")
annotation class SatinClothing

// เสื้อไหมพรม
@RectangleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@AppleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@HourglassBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@InvertedTriangleBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@OvalBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@TrapezoidBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
@PearBodyClothing(nameThai = "เสื้อไหมพรม", nameEnglish = "Silk Clothing")
annotation class SilkClothing

// เสื้อกีฬา
@RectangleBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@AppleBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@HourglassBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@InvertedTriangleBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@OvalBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@TrapezoidBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
@PearBodyClothing(nameThai = "เสื้อกีฬา", nameEnglish = "Sportswear")
annotation class Sportswear

// เสื้อโยคะ
@RectangleBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@AppleBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@HourglassBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@OvalBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
@PearBodyClothing(nameThai = "เสื้อโยคะ", nameEnglish = "Yoga Shirt")
annotation class YogaShirt

// เสื้อยูนิฟอร์ม
@RectangleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@AppleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@HourglassBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@InvertedTriangleBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@OvalBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@TrapezoidBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
@PearBodyClothing(nameThai = "เสื้อยูนิฟอร์ม", nameEnglish = "Uniform")
annotation class Uniform

// เสื้อโอเวอร์ไซส์
@RectangleBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@AppleBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@HourglassBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@OvalBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
@PearBodyClothing(nameThai = "เสื้อโอเวอร์ไซส์", nameEnglish = "Oversized Shirt")
annotation class OversizedShirt

// เสื้อเซฟตี้
@RectangleBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@AppleBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@HourglassBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@OvalBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
@PearBodyClothing(nameThai = "เสื้อเซฟตี้", nameEnglish = "Safety Shirt")
annotation class SafetyShirt

// เสื้อกล้าม
@RectangleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@AppleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@HourglassBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@InvertedTriangleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@OvalBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@TrapezoidBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
@PearBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Top")
annotation class TankTop

// เสื้อฮาวาย
@RectangleBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@AppleBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@HourglassBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@OvalBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
@PearBodyClothing(nameThai = "เสื้อฮาวาย", nameEnglish = "Hawaiian Shirt")
annotation class HawaiianShirt

// เสื้อยีนส์แขนยาว
@RectangleBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@AppleBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@HourglassBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@OvalBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
@PearBodyClothing(nameThai = "เสื้อยีนส์แขนยาว", nameEnglish = "Long Sleeve Denim Shirt")
annotation class LongSleeveDenimShirt

// เสื้อผ้าทำงาน
@RectangleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@AppleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@HourglassBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@InvertedTriangleBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@OvalBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@TrapezoidBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
@PearBodyClothing(nameThai = "เสื้อผ้าทำงาน", nameEnglish = "Workwear")
annotation class Workwear

// เสื้อฮานามิ
@RectangleBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@AppleBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@HourglassBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@OvalBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@TrapezoidBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
@PearBodyClothing(nameThai = "เสื้อฮานามิ", nameEnglish = "Hanami Shirt")
annotation class HanamiShirt

// กางเกงออกกำลังกาย
@RectangleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@AppleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@HourglassBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@InvertedTriangleBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@OvalBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@TrapezoidBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
@PearBodyClothing(nameThai = "กางเกงออกกำลังกาย", nameEnglish = "Activewear")
annotation class Activewear

// กางเกงแฟชั่น
@RectangleBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@AppleBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@HourglassBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@InvertedTriangleBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@OvalBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@TrapezoidBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
@PearBodyClothing(nameThai = "กางเกงแฟชั่น", nameEnglish = "Fashion Pants")
annotation class FashionPants


