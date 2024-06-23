package com.arunwichsapplication.app.modules

class BodyAnalyzer {
    fun determineBodyType(
        frontLength: Double?,
        bustSize: Double?,
        shoulderWidth: Double?,
        waistSize: Double?,
        armLength: Double?,
        hipSize: Double?,
        model: Int?
    ): String? {
        if (frontLength == null || shoulderWidth == null || armLength == null) {
            return null
        }

        val waistToHipRatioRange = 0.8
        val bustToHipRatioLowerRange = 0.8
        val bustToHipRatioUpperRange = 0.85
        val waistToHipRatioLowerRange = 0.8
        val bustToHipRatioLowerOvalRange = 0.8
        val bustToHipRatioUpperOvalRange = 0.85

        val waistToHipRatio = waistSize!! / hipSize!!
        val bustToHipRatio = bustSize!! / hipSize!!

        val bodyType = if (model == 2) {
            when {
                waistToHipRatio < 0.8 && bustToHipRatio >= 0.8 && bustToHipRatio <= 0.85 -> "Hourglass"
                waistToHipRatio >= 0.8 && bustToHipRatio >= 0.8 -> "Apple"
                waistToHipRatio < 0.8 && bustToHipRatio < 0.8 -> "Pear"
                waistToHipRatio >= 0.8 && bustToHipRatio < 0.8 -> "Rectangle"
                waistToHipRatio < 0.8 && bustToHipRatio > 0.85 -> "Inverted Triangle"
                bustToHipRatio <= 0.85 -> "Triangle"
                waistToHipRatio >= 0.8 && bustToHipRatio <= 0.85 -> "Rectangle"
                waistToHipRatio < 0.8 && bustToHipRatio > 0.85 -> "Inverted Triangle"
                waistToHipRatio > 0.85 && bustToHipRatio < 0.8 -> "Oval"
                waistToHipRatio < 0.8 && bustToHipRatio < 0.8 -> "Trapezoid"
                else -> "Unknown"
            }
        } else {
            when {
                waistToHipRatio < waistToHipRatioRange && bustToHipRatio >= bustToHipRatioLowerRange && bustToHipRatio <= bustToHipRatioUpperRange -> "Hourglass"
                waistToHipRatio >= waistToHipRatioLowerRange && bustToHipRatio >= bustToHipRatioLowerRange -> "Apple"
                waistToHipRatio < waistToHipRatioLowerRange && bustToHipRatio < bustToHipRatioLowerRange -> "Pear"
                waistToHipRatio >= waistToHipRatioLowerRange && bustToHipRatio < bustToHipRatioLowerRange -> "Rectangle"
                waistToHipRatio < waistToHipRatioRange && bustToHipRatio > bustToHipRatioUpperRange -> "Inverted Triangle"
                bustToHipRatio <= bustToHipRatioUpperRange -> "Triangle"
                waistToHipRatio >= waistToHipRatioLowerRange && bustToHipRatio <= bustToHipRatioUpperRange -> "Rectangle"
                waistToHipRatio < waistToHipRatioLowerRange && bustToHipRatio > bustToHipRatioUpperRange -> "Inverted Triangle"
                waistToHipRatio > waistToHipRatioLowerRange && bustToHipRatio < bustToHipRatioLowerRange -> "Oval"
                waistToHipRatio < waistToHipRatioRange && bustToHipRatio < bustToHipRatioLowerRange -> "Trapezoid"
                else -> "Unknown"
            }
        }

        return bodyType
    }


    fun calculateBodyTypeAndClothingFit(person: Map<String, Double>, clothing: Map<String, Double>, model: Int?): String {
        val inchToCmRatio = 2.54 // 1 inch = 2.54 cm
        val bustSize = person["bust_size"]?.times(inchToCmRatio)
        val shoulderWidth = person["shoulder_width"]?.times(inchToCmRatio)
        val armLength = person["arm_length"]?.times(inchToCmRatio)
        val frontLength = person["front_length"]?.times(inchToCmRatio)
        val waistSize = person["waist_size"]?.times(inchToCmRatio)
        val hipSize = person["hip_size"]?.times(inchToCmRatio)

        val bodyType = determineBodyType(frontLength, bustSize, shoulderWidth, waistSize, armLength, hipSize, model)



        return when (bodyType) {
            "Hourglass" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }






            }
            "Apple" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }



            }
            "Pear" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }





            }
            "Rectangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }






            }
            "Inverted Triangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }






            }
            "Triangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }



            }
             "Oval" -> {
                 when {
                     // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                     (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                             ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                             ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                     // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                     (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                             ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                             ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                     // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                     (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                             ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                             ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                     // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                     (((clothing["bust"]!! - bustSize!!) < -9) &&
                             ((clothing["waist"]!! - waistSize!!) < -9) &&
                             ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                     // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                     (((clothing["bust"]!! - bustSize!!) > 9) ||
                             ((clothing["waist"]!! - waistSize!!) > 9) ||
                             ((clothing["hip"]!! - hipSize!!) > 9) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                     else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                 }

             }
            "Trapezoid" -> {
                when {
                    // ฟิต (Fits well): ห่างกัน -3 ถึง 7 เซนติเมตร โดยเน้นที่ waist, bust, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -3.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -3.0..7.0) ||
                            ((clothing["hip"]!! - hipSize!!) in -3.0..7.0)) -> "ฟิต (Fits well)"

                    // หลวม (Too Loose): ห่างกัน 8-14 เซนติเมตร โดยเช็คทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 8.0..14.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 8.0..14.0) ||
                            ((clothing["hip"]!! - hipSize!!) in 8.0..14.0)) -> "หลวม (Too Loose)"

                    // คับ (Too Tight): ห่างกัน -15 ถึง -3 เซนติเมตร ในทุกด้าน โดยเน้นที่ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) in -15.0..-3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -15.0..-3.0) &&
                            ((clothing["hip"]!! - hipSize!!) in -15.0..-3.0)) -> "คับ (Too Tight)"

                    // คับเกินไปใส่ไม่ได้ (Way Too Tight): ห่างกัน -9 เซนติเมตร หรือน้อยกว่าในทุกด้าน, เฉพาะ bust, waist, และ hip เท่านั้น
                    (((clothing["bust"]!! - bustSize!!) < -9) &&
                            ((clothing["waist"]!! - waistSize!!) < -9) &&
                            ((clothing["hip"]!! - hipSize!!) < -9)) -> "คับเกินไป (Way Too Tight)"

                    // oversize: ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 9 เซนติเมตร ใน bust, waist, และ hip หรือ shoulder
                    (((clothing["bust"]!! - bustSize!!) > 9) ||
                            ((clothing["waist"]!! - waistSize!!) > 9) ||
                            ((clothing["hip"]!! - hipSize!!) > 9) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 9)) -> "oversize"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }

            }

            else -> "Unknown"
        }
    }
}
