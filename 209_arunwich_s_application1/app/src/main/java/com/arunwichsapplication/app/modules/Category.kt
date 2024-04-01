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
annotation class StructuredJacket1

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
annotation class LowRiseJeans1

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
annotation class BootcutJeans1

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

// A-Line Dresses
@AppleBodyClothing(nameThai = "ชุดเดรสทรง A-line", nameEnglish = "A Line Dresses")
@HourglassBodyClothing(nameThai = "ชุดเดรสทรง A-line", nameEnglish = "A Line Dresses")
@InvertedTriangleBodyClothing(nameThai = "ชุดเดรสทรง A-line", nameEnglish = "A Line Dresses")
@Category("A-Line Dresses")
annotation class ALineDresses

// V-Neck Shirt
@AppleBodyClothing(nameThai = "เสื้อคอวี", nameEnglish = "V Neck Shirt")
@HourglassBodyClothing(nameThai = "เสื้อคอวี", nameEnglish = "V Neck Shirt")
@InvertedTriangleBodyClothing(nameThai = "เสื้อคอวี", nameEnglish = "V Neck Shirt")
@Category("V Neck Shirt")
annotation class VNeckShirt

// Minidress
@AppleBodyClothing(nameThai = "เดรสสั้น", nameEnglish = "Minidress")
@HourglassBodyClothing(nameThai = "เดรสสั้น", nameEnglish = "Minidress")
@InvertedTriangleBodyClothing(nameThai = "เดรสสั้น", nameEnglish = "Minidress")
@Category("Minidress")
annotation class Minidress

// Low-Rise Jeans
@AppleBodyClothing(nameThai = "กางเกงยีนส์ทรงต่ำ", nameEnglish = "Low-Rise Jeans")
@HourglassBodyClothing(nameThai = "กางเกงยีนส์ทรงต่ำ", nameEnglish = "Low-Rise Jeans")
@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์ทรงต่ำ", nameEnglish = "Low-Rise Jeans")
@Category("Low-Rise Jeans")
annotation class LowRiseJeans

// Cropped Jacket
@AppleBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Cropped Jacket")
@HourglassBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Cropped Jacket")
@InvertedTriangleBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Cropped Jacket")
@Category("Cropped Jacket")
annotation class CroppedJacket

// Dresses with Waist Detail
@AppleBodyClothing(nameThai = "เดรสหรือเดรสที่มีรอยยับหรือรอยจับจีบที่ช่วงเอว", nameEnglish = "Dresses with Waist Detail")
@HourglassBodyClothing(nameThai = "เดรสหรือเดรสที่มีรอยยับหรือรอยจับจีบที่ช่วงเอว", nameEnglish = "Dresses with Waist Detail")
@InvertedTriangleBodyClothing(nameThai = "เดรสหรือเดรสที่มีรอยยับหรือรอยจับจีบที่ช่วงเอว", nameEnglish = "Dresses with Waist Detail")
@Category("Dresses with Waist Detail")
annotation class DressesWithWaistDetail

// High-Waisted Skirts
@AppleBodyClothing(nameThai = "กระโปรงเอวสูง", nameEnglish = "High-Waisted Skirts")
@HourglassBodyClothing(nameThai = "กระโปรงเอวสูง", nameEnglish = "High-Waisted Skirts")
@InvertedTriangleBodyClothing(nameThai = "กระโปรงเอวสูง", nameEnglish = "High-Waisted Skirts")
@Category("High-Waisted Skirts")
annotation class HighWaistedSkirts

// Skinny Jeans
@HourglassBodyClothing(nameThai = "กางเกงยีนส์สกินนี่", nameEnglish = "Skinny Jeans")
@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์สกินนี่", nameEnglish = "Skinny Jeans")
@Category("Skinny Jeans")
annotation class SkinnyJeans1

// Pencil Skirts
@HourglassBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirts")
@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirts")
@Category("Pencil Skirts")
annotation class PencilSkirts

// Off Shoulder Dresses
@AppleBodyClothing(nameThai = "เดรสเกาะอก", nameEnglish = "Off Shoulder Dresses")
@HourglassBodyClothing(nameThai = "เดรสเกาะอก", nameEnglish = "Off Shoulder Dresses")
@InvertedTriangleBodyClothing(nameThai = "เดรสเกาะอก", nameEnglish = "Off Shoulder Dresses")
@Category("Off Shoulder Dresses")
annotation class OffShoulderDresses

// Wide Neck Tops
@AppleBodyClothing(nameThai = "เสื้อที่มีคอกว้าง", nameEnglish = "Wide Neck Tops")
@HourglassBodyClothing(nameThai = "เสื้อที่มีคอกว้าง", nameEnglish = "Wide Neck Tops")
@InvertedTriangleBodyClothing(nameThai = "เสื้อที่มีคอกว้าง", nameEnglish = "Wide Neck Tops")
@Category("Wide Neck Tops")
annotation class WideNeckTops

// Blazers
@AppleBodyClothing(nameThai = "เบลเชอร์แบบยาว", nameEnglish = "Blazers")
@HourglassBodyClothing(nameThai = "เบลเชอร์แบบยาว", nameEnglish = "Blazers")
@InvertedTriangleBodyClothing(nameThai = "เบลเชอร์แบบยาว", nameEnglish = "Blazers")
@Category("Blazers")
annotation class Blazers

// Straight Leg Jeans
@HourglassBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Straight Leg Jeans")
@Category("Straight Leg Jeans")
annotation class StraightLegJeans

// Bootcut Jeans
@HourglassBodyClothing(nameThai = "กางเกงทรงบาน", nameEnglish = "Bootcut Jeans")
@Category("Bootcut Jeans")
annotation class BootcutJeans

// Palazzo Pants
@HourglassBodyClothing(nameThai = "กางเกงทรงพาลาซโซ", nameEnglish = "Palazzo Pants")
@PearBodyClothing(nameThai = "กางเกงทรงพาลาซโซ", nameEnglish = "Palazzo Pants")
@Category("Palazzo Pants")
annotation class PalazzoPants

// A-Line Skirts
@HourglassBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "A-Line Skirts")
@Category("A-Line Skirts")
annotation class ALineSkirts

// Heart Neckline Tops
@AppleBodyClothing(nameThai = "เสื้อที่มีคอเป็นรูปหัวใจ", nameEnglish = "Heart Neckline Tops")
@Category("Heart Neckline Tops")
annotation class HeartNecklineTops

// Tank Tops
@AppleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Tank Tops")
@Category("Tank Tops")
annotation class TankTops

// Structured Jacket
@AppleBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Structured Jacket")
@HourglassBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Structured Jacket")
@InvertedTriangleBodyClothing(nameThai = "แจ็คเก็ตที่มีขนาดพอดีกับรูปร่าง", nameEnglish = "Structured Jacket")
@Category("Structured Jacket")
annotation class StructuredJacket


@AppleBodyClothing(nameThai = "แจ็คเก็ต", nameEnglish = "Jacket")
annotation class Jacket

@AppleBodyClothing(nameThai = "เสื้อคอกลมเข้ารูป", nameEnglish = "Fitted Round Neck Top")
annotation class FittedRoundNeckTop

@AppleBodyClothing(nameThai = "เสื้อยืด", nameEnglish = "T-shirt")
annotation class TShirt

@AppleBodyClothing(nameThai = "เสื้อเปิดไหล่", nameEnglish = "Off-shoulder Top")
annotation class OffShoulderTop

@AppleBodyClothing(nameThai = "เสื้อยาวปิดสะโพก", nameEnglish = "Long Top")
annotation class LongTop

@AppleBodyClothing(nameThai = "เสื้อเชิ้ตคอปก", nameEnglish = "Button-up Shirt")
annotation class ButtonUpShirt

@AppleBodyClothing(nameThai = "เสื้อทรง Trapeze", nameEnglish = "Trapeze Top")
@InvertedTriangleBodyClothing(nameThai = "เสื้อทรง Trapeze", nameEnglish = "Trapeze Top")
annotation class TrapezeTop

@AppleBodyClothing(nameThai = "เสื้อทรง Wrap", nameEnglish = "Wrap Top")
annotation class WrapTop

@AppleBodyClothing(nameThai = "เสื้อทรง Empire", nameEnglish = "Empire Top")
annotation class EmpireTop

@AppleBodyClothing(nameThai = "เสื้อทรง Tunic", nameEnglish = "Tunic Top")
annotation class TunicTop

@AppleBodyClothing(nameThai = "เสื้อยืดปล่อยชาย", nameEnglish = "Loose T-shirt")
annotation class LooseTShirt



@AppleBodyClothing(nameThai = "กางเกงเอวสูง", nameEnglish = "High-Waisted Pants")
annotation class HighWaistedPants


@AppleBodyClothing(nameThai = "กางเกงขาสั้นทรงเอ", nameEnglish = "A-line Shorts")
annotation class ALineShorts

@AppleBodyClothing(nameThai = "กางเกงยีนส์ขาม้า", nameEnglish = "Wide Leg Jeans")
annotation class WideLegJeans



@AppleBodyClothing(nameThai = "กางเกงยีนส์ขาบาน", nameEnglish = "Flared Jeans")
annotation class FlaredJeans


@AppleBodyClothing(nameThai = "กระโปรงจีบ", nameEnglish = "A-line Skirt")
annotation class ALineSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "Straight Skirt")
annotation class StraightSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรงทิวลิป", nameEnglish = "Tulip Skirt")
@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงทิวลิป", nameEnglish = "Tulip Skirt")
annotation class TulipSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรงบอลลูน", nameEnglish = "Bubble Skirt")
annotation class BubbleSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรง Bias", nameEnglish = "Bias Skirt")
annotation class BiasSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรงระฆัง", nameEnglish = "Bell Skirt")
annotation class BellSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรงยิปซี", nameEnglish = "Yippee Skirt")
annotation class YippeeSkirt

@AppleBodyClothing(nameThai = "กระโปรงทรง Asymmetric", nameEnglish = "Asymmetric Skirt")
annotation class AsymmetricSkirt


@AppleBodyClothing(nameThai = "Empire Waist Dress", nameEnglish = "Empire Waist Dress")
annotation class EmpireWaistDress

@AppleBodyClothing(nameThai = "Wrap dress", nameEnglish = "Wrap Dress")
annotation class WrapDress

@AppleBodyClothing(nameThai = "Bias dress", nameEnglish = "Bias Cut Dress")
annotation class BiasCutDress

@AppleBodyClothing(nameThai = "Shift dress", nameEnglish = "Shift Dress")
annotation class ShiftDress

@HourglassBodyClothing(nameThai = "เสื้อคอวีทรงสลิม", nameEnglish = "Slim Fit V-neck Top")
annotation class SlimFitVNeckTop

@HourglassBodyClothing(nameThai = "เสื้อคอเหลี่ยมทรงสลิม", nameEnglish = "Slim Fit Square Neck Top")
annotation class SlimFitSquareNeckTop

@HourglassBodyClothing(nameThai = "เสื้อยืดทรงสลิมฟิต", nameEnglish = "Slim Fit Stretchy Top")
annotation class SlimFitStretchyTop

@HourglassBodyClothing(nameThai = "เสื้อพอดีตัว", nameEnglish = "Fitted Top")
annotation class FittedTop

@HourglassBodyClothing(nameThai = "เสื้อ Wrap", nameEnglish = "Wrap Top")
annotation class WrapTop2

@HourglassBodyClothing(nameThai = "เสื้อทรง Peplum", nameEnglish = "Peplum Top")
annotation class PeplumTop

@HourglassBodyClothing(nameThai = "เสื้อเข้ารูป", nameEnglish = "Form-fitting Top")
annotation class FormFittingTop

@HourglassBodyClothing(nameThai = "สกินนี่ยีนส์", nameEnglish = "Skinny Jeans")
annotation class SkinnyJeans2

@HourglassBodyClothing(nameThai = "กางเกงขากว้าง", nameEnglish = "Wide Leg Pants")
annotation class WideLegPants2

@HourglassBodyClothing(nameThai = "กางเกงขาบาน", nameEnglish = "Flared Pants")
annotation class FlaredPants

@HourglassBodyClothing(nameThai = "กางเกงยีนส์ขาม้า", nameEnglish = "Wide Leg Jeans")
annotation class WideLegJeans2

@HourglassBodyClothing(nameThai = "กางเกงยีนส์กระบอกเล็ก", nameEnglish = "Skinny Jeans (Small Waist)")
annotation class SkinnyJeansSmallWaist

@HourglassBodyClothing(nameThai = "กางเกงยีนส์กระบอกใหญ่", nameEnglish = "Skinny Jeans (Big Waist)")
annotation class SkinnyJeansBigWaist

@HourglassBodyClothing(nameThai = "กางเกงยีนส์ขาบาน", nameEnglish = "Flared Jeans")
annotation class FlaredJeans2

@HourglassBodyClothing(nameThai = "กระโปรงเอวสูง", nameEnglish = "High-Waisted Skirt")
annotation class HighWaistedSkirt2

@HourglassBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirt")
annotation class PencilSkirt2

@HourglassBodyClothing(nameThai = "กระโปรงจีบ", nameEnglish = "A-line Skirt")
annotation class ALineSkirt2

@HourglassBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "Straight Skirt")
annotation class StraightSkirt2

@HourglassBodyClothing(nameThai = "กระโปรงทรงทิวลิป", nameEnglish = "Tulip Skirt")
annotation class TulipSkirt2

@HourglassBodyClothing(nameThai = "Peoplum dress", nameEnglish = "Peplum Dress")
annotation class PeplumDress

@HourglassBodyClothing(nameThai = "Wrop dress", nameEnglish = "Wrap Dress")
annotation class WrapDress2

@HourglassBodyClothing(nameThai = "Bias dress", nameEnglish = "Bias Cut Dress")
annotation class BiasCutDress2

@HourglassBodyClothing(nameThai = "Shift dress", nameEnglish = "Shift Dress")
annotation class ShiftDress2

@HourglassBodyClothing(nameThai = "Panelled waist", nameEnglish = "Panelled Waist Dress")
@InvertedTriangleBodyClothing(nameThai = "Panelled waist", nameEnglish = "Panelled Waist Dress")
annotation class PanelledWaistDress


@PearBodyClothing(nameThai = "เสื้อคอกว้าง", nameEnglish = "Wide Neck Top")
annotation class WideNeckTop

@PearBodyClothing(nameThai = "เบลเซอร์แบบยาว", nameEnglish = "Long Blazer")
annotation class LongBlazer

@PearBodyClothing(nameThai = "เสื้อทูนิค", nameEnglish = "Tunic Top")
annotation class TunicTop2

@PearBodyClothing(nameThai = "เสื้อคอเหลี่ยม", nameEnglish = "Square Neck Top")
annotation class SquareNeckTop

@PearBodyClothing(nameThai = "เสื้อรัดรูป", nameEnglish = "Form-fitting Top")
annotation class FormFittingTop2

@PearBodyClothing(nameThai = "เสื้อปาดไหล่", nameEnglish = "Off-shoulder Top")
annotation class OffShoulderTop2

@PearBodyClothing(nameThai = "เสื้อแขนเล็ก", nameEnglish = "Short-sleeve Top")
annotation class ShortSleeveTop

@PearBodyClothing(nameThai = "เสื้อครอป", nameEnglish = "Crop Top")
annotation class CropTop

@PearBodyClothing(nameThai = "เสื้อทรง Wrap", nameEnglish = "Wrap Top")
annotation class WrapTop3

@PearBodyClothing(nameThai = "เสื้อทรง Raffle", nameEnglish = "Ruffle Top")
annotation class RuffleTop

@PearBodyClothing(nameThai = "เสื้อลายทาง", nameEnglish = "Striped Top")
annotation class StripedTop

@PearBodyClothing(nameThai = "เสื้อที่มีลูกเล่นตรงอก", nameEnglish = "Embellished Top")
annotation class EmbellishedTop

@PearBodyClothing(nameThai = "กางเกงทรงกระบอก", nameEnglish = "Bootcut Pants")
annotation class BootcutPants2

@PearBodyClothing(nameThai = "กางเกงทรงเอ", nameEnglish = "Straight-leg Pants")
annotation class StraightLegPants3

@PearBodyClothing(nameThai = "กางเกงทรงบาน", nameEnglish = "Flared Pants")
annotation class FlaredPants3


@PearBodyClothing(nameThai = "กางเกงขาสั้นทรงเอ", nameEnglish = "A-line Shorts")
annotation class ALineShorts2

@PearBodyClothing(nameThai = "กางเกงขากว้าง", nameEnglish = "Wide Leg Pants")
annotation class WideLegPants3

@PearBodyClothing(nameThai = "กางเกง Bootcut", nameEnglish = "Bootcut Pants")
annotation class BootcutPants3

@PearBodyClothing(nameThai = "กางเกงยีนส์ขาม้า", nameEnglish = "Wide Leg Jeans")
annotation class WideLegJeans3

@PearBodyClothing(nameThai = "กางเกงยีนส์กระบอกใหญ่", nameEnglish = "Skinny Jeans (Big Waist)")
annotation class SkinnyJeansBigWaist2

@PearBodyClothing(nameThai = "กางเกงยีนส์ขาบาน", nameEnglish = "Flared Jeans")
annotation class FlaredJeans3

@PearBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "Straight Skirt")
annotation class StraightSkirt3

@PearBodyClothing(nameThai = "กระโปรงพลีท", nameEnglish = "Pleated Skirt")
annotation class PleatedSkirt

@PearBodyClothing(nameThai = "กระโปรงทรง Bias", nameEnglish = "Bias Cut Skirt")
annotation class BiasCutSkirt

@PearBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirt")
annotation class PencilSkirt3

@PearBodyClothing(nameThai = "เดรสเกาะอก", nameEnglish = "Off-shoulder Dress")
annotation class OffShoulderDress

@PearBodyClothing(nameThai = "tulip-dress", nameEnglish = "Tulip Dress")
annotation class TulipDress

@PearBodyClothing(nameThai = "A-line dress", nameEnglish = "A-line Dress")
annotation class ALineDress2

@PearBodyClothing(nameThai = "Wrop dress", nameEnglish = "Wrap Dress")
annotation class WrapDress3

@PearBodyClothing(nameThai = "Empire dress", nameEnglish = "Empire Dress")
annotation class EmpireDress

@PearBodyClothing(nameThai = "X-line dress", nameEnglish = "X-line Dress")
annotation class XLineDress

@RectangleBodyClothing(nameThai = "เสื้อคอรูปหัวใจ", nameEnglish = "Sweetheart Neckline Top")
annotation class SweetheartNecklineTop

@RectangleBodyClothing(nameThai = "เสื้อคอ V", nameEnglish = "V-neck Top")
annotation class VNeckTop2

@RectangleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Sleeveless Top")
annotation class SleevelessTop

@RectangleBodyClothing(nameThai = "เสื้อทรง Peplum", nameEnglish = "Peplum Top")
annotation class PeplumTop2

@RectangleBodyClothing(nameThai = "เสื้อ Wrap", nameEnglish = "Wrap Top")
annotation class WrapTop4

@RectangleBodyClothing(nameThai = "เสื้อ Ruffle", nameEnglish = "Ruffle Top")
annotation class RuffleTop2

@RectangleBodyClothing(nameThai = "เสื้อที่มีลูกเล่น", nameEnglish = "Embellished Top")
annotation class EmbellishedTop2

@RectangleBodyClothing(nameThai = "กางเกงทรงเอ", nameEnglish = "Straight-leg Pants")
annotation class StraightLegPants4

@RectangleBodyClothing(nameThai = "สกินนี่ยีนส์", nameEnglish = "Skinny Jeans")
annotation class SkinnyJeans4

@RectangleBodyClothing(nameThai = "กางเกงยีนส์ขาม้า", nameEnglish = "Wide Leg Jeans")
annotation class WideLegJeans4

@RectangleBodyClothing(nameThai = "กางเกงยีนส์กระบอกเล็ก", nameEnglish = "Skinny Jeans (Small Waist)")
annotation class SkinnyJeansSmallWaist2

@RectangleBodyClothing(nameThai = "กางเกงยีนส์กระบอกใหญ่", nameEnglish = "Skinny Jeans (Big Waist)")
annotation class SkinnyJeansBigWaist3

@RectangleBodyClothing(nameThai = "กางเกงยีนส์ขาบาน", nameEnglish = "Flared Jeans")
annotation class FlaredJeans4

@RectangleBodyClothing(nameThai = "กางเกงทรง boot cut", nameEnglish = "Bootcut Pants")
annotation class BootcutPants4

@RectangleBodyClothing(nameThai = "กระโปรงทรงสอบ", nameEnglish = "Pencil Skirt")
annotation class PencilSkirt4

@RectangleBodyClothing(nameThai = "กระโปรงทรงระบาย", nameEnglish = "Tiered Skirt")
annotation class TieredSkirt

@RectangleBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "Straight Skirt")
annotation class StraightSkirt4

@RectangleBodyClothing(nameThai = "กระโปรงทรงบาน", nameEnglish = "Flared Skirt")
annotation class FlaredSkirt4

@RectangleBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirt")
annotation class PencilSkirt5

@RectangleBodyClothing(nameThai = "กระโปรงทรงบอลลูน", nameEnglish = "Ballgown Skirt")
annotation class BallgownSkirt

@RectangleBodyClothing(nameThai = "Empire dress", nameEnglish = "Empire Dress")
annotation class EmpireDress2

@RectangleBodyClothing(nameThai = "Princess seams", nameEnglish = "Princess Seams Dress")
annotation class PrincessSeamsDress

@RectangleBodyClothing(nameThai = "X-line dress", nameEnglish = "X-line Dress")
annotation class XLineDress2

@RectangleBodyClothing(nameThai = "Wrap dress", nameEnglish = "Wrap Dress")
annotation class WrapDress4

@RectangleBodyClothing(nameThai = "Shift dress", nameEnglish = "Shift Dress")
annotation class ShiftDress3

@InvertedTriangleBodyClothing(nameThai = "เสื้อกล้าม", nameEnglish = "Muscle Tank Top")
annotation class MuscleTankTop

@InvertedTriangleBodyClothing(nameThai = "เสื้อคอ V", nameEnglish = "V-neck Top")
annotation class VNeckTop3

@InvertedTriangleBodyClothing(nameThai = "เบลเซอร์", nameEnglish = "Blazer")
annotation class Blazer



@InvertedTriangleBodyClothing(nameThai = "เสื้อทรง Peplum", nameEnglish = "Peplum Top")
annotation class PeplumTop3

@InvertedTriangleBodyClothing(nameThai = "เสื้อขนาดพอดีตัว", nameEnglish = "Fitted Top")
annotation class FittedTop3

@InvertedTriangleBodyClothing(nameThai = "เสื้อ Wrap", nameEnglish = "Wrap Top")
annotation class WrapTop5

@InvertedTriangleBodyClothing(nameThai = "เสื้อเข้ารูป", nameEnglish = "Form-fitting Top")
annotation class FormFittingTop3

@InvertedTriangleBodyClothing(nameThai = "กางเกงทรงเอ", nameEnglish = "Straight-leg Pants")
annotation class StraightLegPants5

@InvertedTriangleBodyClothing(nameThai = "สกินนี่ยีนส์", nameEnglish = "Skinny Jeans")
annotation class SkinnyJeans5

@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์ขาม้า", nameEnglish = "Wide Leg Jeans")
annotation class WideLegJeans5

@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์ทรงบอย", nameEnglish = "Boyfriend Jeans")
annotation class BoyfriendJeans

@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์ขาบาน", nameEnglish = "Flared Jeans")
annotation class FlaredJeans5

@InvertedTriangleBodyClothing(nameThai = "กางเกงยีนส์ขากระดิ่ง", nameEnglish = "Bell-bottom Jeans")
annotation class BellBottomJeans

@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงเอ", nameEnglish = "Straight Skirt")
annotation class StraightSkirt5

@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงดินสอ", nameEnglish = "Pencil Skirt")
annotation class PencilSkirt6


@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงระบาย", nameEnglish = "Tiered Skirt")
annotation class TieredSkirt2

@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรงป้าย", nameEnglish = "Tag Skirt")
annotation class TagSkirt

@InvertedTriangleBodyClothing(nameThai = "กระโปรงทรง Bias", nameEnglish = "Bias Cut Skirt")
annotation class BiasCutSkirt2

@InvertedTriangleBodyClothing(nameThai = "Shift dress", nameEnglish = "Shift Dress")
annotation class ShiftDress4

@InvertedTriangleBodyClothing(nameThai = "Pleated dress", nameEnglish = "Pleated Dress")
annotation class PleatedDress

@InvertedTriangleBodyClothing(nameThai = "A-line dress", nameEnglish = "A-line Dress")
annotation class ALineDress3


@InvertedTriangleBodyClothing(nameThai = "Nipped dress", nameEnglish = "Nipped Dress")
annotation class NippedDress
