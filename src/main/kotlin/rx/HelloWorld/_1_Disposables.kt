package rx.HelloWorld

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import rx.Console
import java.util.concurrent.TimeUnit

object Disposables {

    @JvmStatic
    fun main(arg: Array<String>) {
        val observable = Observable.create<String> {
            Console.log("created emmiter and emmited element")
            it.onNext("Hello World!")
            it.onComplete()
        }.delay(2000, TimeUnit.MILLISECONDS)


        val disposable = observable.subscribe {
            Console.log(it)
        }

        Thread.sleep(5000)
    }
}






object DisposablesDisposed {

    @JvmStatic
    fun main(arg: Array<String>) {
        val disposeBag = CompositeDisposable()

        val observable = Observable.create<String> {
            Console.log("created emmiter and emmited element")
            it.onNext("Hello World!")
            it.onComplete()
        }.delay(2000, TimeUnit.MILLISECONDS)


        val disposable = observable.subscribe {
            Console.log(it)
        }

        disposeBag.add(disposable)
        disposeBag.dispose()

        Thread.sleep(5000)
    }
}






object HowToKnow {

    @JvmStatic
    fun main(arg: Array<String>) {
        val disposeBag = CompositeDisposable()

        val observable = Observable.create<String> {
            Console.log("created emmiter and emmited element")
            it.onNext("Hello World!")
            it.onComplete()

            it.setCancellable {
                Console.log("OMG CANCELLED! WTF?")
                Console.log("is it disposed on after cancell? ${it.isDisposed}")
            }

            Console.log("is it disposed on start? ${it.isDisposed}")


            val disposable = object : Disposable {
                override fun isDisposed(): Boolean {
                    return false
                }

                override fun dispose() {
                    Console.log("OMG DISPOSED!")
                    Console.log("is it disposed on dispose? ${it.isDisposed}")
                }
            }

            it.setDisposable(disposable)

        }.delay(2000, TimeUnit.MILLISECONDS)


        val disposable = observable.subscribe {
            Console.log(it)
        }

        disposeBag.add(disposable)
        disposeBag.dispose()

        Thread.sleep(5000)
    }
}