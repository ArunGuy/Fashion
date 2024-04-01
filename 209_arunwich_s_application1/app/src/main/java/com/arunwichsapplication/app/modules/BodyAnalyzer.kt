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
        val frontLength = person["front_length"]
        val bustSize = person["bust_size"]
        val shoulderWidth = person["shoulder_width"]
        val waistSize = person["waist_size"]
        val armLength = person["arm_length"]
        val hipSize = person["hip_size"]

        if (armLength == null && shoulderWidth == null && frontLength == null) {
            return "Incomplete data"
        }
        if (frontLength == null) {
            return "Incomplete front_length"
        }
        if (shoulderWidth == null) {
            return "Incomplete shoulder_width"
        }
        if (armLength == null) {
            return "Incomplete arm_length"
        }
        if (armLength == null && shoulderWidth == null) {
            return "Incomplete arm_length, shoulder_width"
        }
        if (armLength == null && frontLength == null) {
            return "Incomplete arm_length, front_length"
        }
        if (shoulderWidth == null && frontLength == null) {
            return "Incomplete shoulder_width, front_length"
        }

        val bodyType = determineBodyType(frontLength, bustSize, shoulderWidth, waistSize, armLength, hipSize, model)

        return when (bodyType) {
            "Hourglass" -> {
                when {
                    (clothing["shoulder"]!! - shoulderWidth!!) < 5 && (clothing["waist"]!! - waistSize!!) < 5 && (clothing["hip"]!! - hipSize!!) < 5 -> "Fits well"
                    (clothing["shoulder"]!! - shoulderWidth) >= 5 && (clothing["waist"]!! - waistSize!!!!) >= 5 && (clothing["hip"]!! - hipSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            "Apple" -> {
                when {
                    (clothing["bust"]!! - bustSize!!) < 5 && (clothing["waist"]!! - waistSize!!) < 5 -> "Fits well"
                    (clothing["bust"]!! - bustSize) >= 5 && (clothing["waist"]!! - waistSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            "Pear" -> {
                when {
                    (clothing["waist"]!! - waistSize!!) < 5 && (clothing["hip"]!! - hipSize!!) < 5 -> "Fits well"
                    (clothing["waist"]!! - waistSize) >= 5 && (clothing["hip"]!! - hipSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            "Rectangle" -> {
                when {
                    (clothing["shoulder"]!! - shoulderWidth!!) < 5 && (clothing["bust"]!! - bustSize!!) < 5 -> "Fits well"
                    (clothing["shoulder"]!! - shoulderWidth) >= 5 && (clothing["bust"]!! - bustSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            "Inverted Triangle" -> {
                when {
                    (clothing["shoulder"]!! - shoulderWidth!!) < 5 && (clothing["hip"]!! - hipSize!!) < 5 -> "Fits well"
                    (clothing["shoulder"]!! - shoulderWidth) >= 5 && (clothing["hip"]!! - hipSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            "Triangle", "Oval", "Trapezoid" -> {
                when {
                    (clothing["waist"]!! - waistSize!!) < 5 && (clothing["hip"]!! - hipSize!!) < 5 -> "Fits well"
                    (clothing["waist"]!! - waistSize) >= 5 && (clothing["hip"]!! - hipSize!!) >= 5 -> "Too Tight"
                    else -> "Too Loose"
                }
            }
            else -> "Unknown"
        }
    }
}
