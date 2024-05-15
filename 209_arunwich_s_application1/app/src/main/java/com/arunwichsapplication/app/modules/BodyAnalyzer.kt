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
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }

            }
            "Apple" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }


            }
            "Pear" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }


            }
            "Rectangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }


            }
            "Inverted Triangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }


            }
            "Triangle" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }


            }
             "Oval" -> {
                 when {
                     // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                     ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                             ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                             ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                             ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                             ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                     // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                     ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                             ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                             ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                             ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                     // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                     ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                             ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                             ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                             ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                     // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                     ((clothing["bust"]!! - bustSize!!) > 10) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                             ((clothing["arm"]!! - armLength!!) > 10) ||
                             ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                             ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                     // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                     (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                             ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                             ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                             ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                     // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                     (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                             ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                             ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                             ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                             ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                     // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                     ((clothing["bust"]!! - bustSize!!) < -5) &&
                             ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                             ((clothing["arm"]!! - armLength!!) < -5) &&
                             ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                             ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                     // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                     ((clothing["bust"]!! - bustSize!!) < -10) &&
                             ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                             ((clothing["arm"]!! - armLength!!) < -10) &&
                             ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                             ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                     else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                 }


             }
            "Trapezoid" -> {
                when {
                    // ฟิต (Fits well): ห่างกันน้อยกว่าหรือเท่ากับ 3 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in -3.0..3.0) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -3.0..3.0) &&
                            ((clothing["arm"]!! - armLength!!) in -3.0..3.0) &&
                            ((clothing["frontLength"]!! - frontLength!!) in -3.0..3.0) &&
                            ((clothing["waist"]!! - waistSize!!) in -3.0..3.0) -> "ฟิต (Fits well)"

                    // คับ (Too Tight): ห่างกัน 4-7 เซนติเมตร
                    ((clothing["bust"]!! - bustSize!!) in 4.0..7.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 4.0..7.0) ||
                            ((clothing["arm"]!! - armLength!!) in 4.0..7.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 4.0..7.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 4.0..7.0) -> "คับ (Too Tight)"

                    // หลวม (Too Loose): ห่างกัน 8-10 เซนติเมตร หรือมากกว่านั้น
                    ((clothing["bust"]!! - bustSize!!) in -10.0..-8.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-8.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-8.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-8.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-8.0) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่เกิน 10 เซนติเมตร ในอย่างน้อยหนึ่งด้าน
                    ((clothing["bust"]!! - bustSize!!) > 10) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) > 10) ||
                            ((clothing["arm"]!! - armLength!!) > 10) ||
                            ((clothing["frontLength"]!! - frontLength!!) > 10) ||
                            ((clothing["waist"]!! - waistSize!!) > 10) -> "oversize"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ -5 ถึง -10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in -10.0..-5.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in -10.0..-5.0) ||
                            ((clothing["arm"]!! - armLength!!) in -10.0..-5.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in -10.0..-5.0) ||
                            ((clothing["waist"]!! - waistSize!!) in -10.0..-5.0)) -> "คับ (Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่ใกล้เคียงกับ 5 ถึง 10 เซนติเมตร ในทุกด้าน
                    (((clothing["bust"]!! - bustSize!!) in 5.0..10.0) ||
                            ((clothing["shoulder"]!! - shoulderWidth!!) in 5.0..10.0) ||
                            ((clothing["arm"]!! - armLength!!) in 5.0..10.0) ||
                            ((clothing["frontLength"]!! - frontLength!!) in 5.0..10.0) ||
                            ((clothing["waist"]!! - waistSize!!) in 5.0..10.0)) -> "หลวม (Too Loose)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -5 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -5) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -5) &&
                            ((clothing["arm"]!! - armLength!!) < -5) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -5) &&
                            ((clothing["waist"]!! - waistSize!!) < -5) -> "คับเกินไป (Way Too Tight)"

                    // ถ้าขนาดของเสื้อผ้ามีความแตกต่างจากขนาดของผู้ใส่น้อยกว่า -10 เซนติเมตร ในทุกด้าน
                    ((clothing["bust"]!! - bustSize!!) < -10) &&
                            ((clothing["shoulder"]!! - shoulderWidth!!) < -10) &&
                            ((clothing["arm"]!! - armLength!!) < -10) &&
                            ((clothing["frontLength"]!! - frontLength!!) < -10) &&
                            ((clothing["waist"]!! - waistSize!!) < -10) -> "คับเกินไป (Way Too Tight)"

                    else -> "ไม่เหมาะสมกับรูปร่างของคุณ"
                }



            }

            else -> "Unknown"
        }
    }
}
