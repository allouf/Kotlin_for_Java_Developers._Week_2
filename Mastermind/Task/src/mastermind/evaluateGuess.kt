package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    var compareSecret = secret
    var compareGuess = guess

    for((idx, value) in guess.withIndex()){
        if(value == secret[idx]){
                rightPosition++
                compareGuess = compareGuess.replaceFirst(value, '0')
                if (secret[idx] == compareSecret[idx]) {
                    compareSecret = compareSecret.replaceFirst(value, '0')
                }
                else{
                    wrongPosition--
                }
            }
            else {
                wrongPosition += kotlin.math.min(compareSecret.count{ it == value }, compareGuess.count{ it == value })
                compareSecret = compareSecret.replace(value,'0')
            }
        }
    return Evaluation(rightPosition, wrongPosition)
}
