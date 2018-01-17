package rx.HelloWorld

import io.reactivex.Observable
import rx.Console

object Filter {

    @JvmStatic
    fun main(arg: Array<String>) {
        val list = ArrayList<Int>(100)
        list += 0..100

        Observable.create<Int> { emitter ->
            list.forEach { emitter.onNext(it) }
            emitter.onComplete()
        }
                .doOnNext { Console.log("$it - wszystkie") }
                .filter { it % 2 == 0 }
                .subscribe { Console.log("$it - nieparzyste") }
    }
}