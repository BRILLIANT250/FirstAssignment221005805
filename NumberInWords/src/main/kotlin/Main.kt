fun main(args: Array<String>) {
    print("Enter an integer (up to six digits): ")
    val number = readln().toInt()

    if (number in 0..999999) {
        val numberInWords = convertToWords(number)
        println("In words: $numberInWords")
    } else {
        println("Invalid input. Please enter a valid integer up to six digits.")
    }
}

fun convertToWords(number: Int): String {
    if (number == 0) return "zero"

    val units = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = listOf("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = listOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    fun convertGroup(num: Int): String {
        val result = mutableListOf<String>()

        if (num / 100 > 0) {
            result.add("${units[num / 100]} hundred")
        }

        val remainder = num % 100

        if (remainder in 11..19) {
            result.add(teens[remainder - 10])
        } else {
            if (remainder / 10 > 0) {
                result.add(tens[remainder / 10])
            }
            if (remainder % 10 > 0) {
                result.add(units[remainder % 10])
            }
        }

        return result.joinToString(" ")
    }

    val thousandPart = convertGroup(number / 1000)
    val restPart = convertGroup(number % 1000)

    val parts = listOf(thousandPart, "thousand", restPart)

    return parts.joinToString(" ")
}
