fun validateCitizenId(id: String): Boolean {
    if (id.length != 13 || !id.all { it.isDigit() }) {
        return false
    }

    val sum = (0..11).sumOf { index ->
        id[index].digitToInt() * (13 - index)
    }

    val checkDigit = (11 - (sum % 11)) % 10
    return checkDigit == id[12].digitToInt()
}
