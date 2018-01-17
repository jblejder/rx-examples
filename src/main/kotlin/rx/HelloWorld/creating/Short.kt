package rx.HelloWorld.creating

import io.reactivex.Observable
import rx.Console

object Short {

    @JvmStatic
    fun main(arg: Array<String>) {
        Observable.create<String> {
            it.onNext("Hello World!")
            it.onComplete()
        }.subscribe { s -> Console.log(s) }
    }
}
