fun main(args: Array<String>) {
    val database = mapOf(
        "users1.csv" to listOf(32, 45, 17, -1, 34),
        "users2.csv" to listOf(19,-1, 67, 22),
        "users3.csv" to listOf(15, -124, 0, 12),
        "users4.csv" to listOf(56, 32, 18, 44)
    )

    val middleAges =  database.flatMap{it.value}.filter{it > 0}.average()
    	//print(middleAges)

    val amountIncompleteData = database.flatMap{it.value}.filter{it < 0}.count()
    	//print(amountIncompleteData)
}