package music_lover

import kotlin.random.Random

const val DISCOUNT_UP_TO_10_000= 100_00u
const val DISCOUNT_FROM_10_000 = 5u
const val DISCOUNT_MUSIC_LOVER = 1u
const val COMPOSITION_PRICE = 100_00u
/* так как при припокупке 1 композиции итоговая сумма может составить 0,
ввел такой параметр как: MIN_AMOUNT_OF_COMPOSITION в 2 шт.
И вообще скидка в 100 руб. не логична, при покупки на сумму меньше 20_000 руб, при прошлой покупке меньше 10_000 руб
скидка будет больше чем у пользователя с прошлой покупкой более 10_000 руб!!!
 */
const val MIN_AMOUNT_OF_COMPOSITION = 2u
const val HUNDRED = 100u

fun main() {
    print("Введите количество композиций: ")
    val amountOfComposition = readln().toUInt()
    val orderPrice = amountOfComposition * COMPOSITION_PRICE
    val previousPurchase = Random.nextInt(100, 20_000)

    val discount = if (previousPurchase > 1_000 && previousPurchase <= 10_000) DISCOUNT_UP_TO_10_000 else (orderPrice * DISCOUNT_FROM_10_000) / HUNDRED
    val purchaseAmount = if (previousPurchase <= 1_000 || amountOfComposition <= MIN_AMOUNT_OF_COMPOSITION) orderPrice else orderPrice - discount

    val musicLover = Random.nextBoolean()
    val purchaseAmountMusicLover = if (musicLover) purchaseAmount - (purchaseAmount * DISCOUNT_MUSIC_LOVER) / HUNDRED else purchaseAmount
    val rub = purchaseAmountMusicLover / HUNDRED
    val kop = purchaseAmountMusicLover % HUNDRED
    println("Ваша покупка с учетом все скидок составила: $rub руб. $kop коп.")
}