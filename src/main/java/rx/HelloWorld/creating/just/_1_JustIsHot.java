package rx.HelloWorld.creating.just;

import io.reactivex.Observable;
import rx.Console;

class _1_JustIsHot {
    public static void main(String[] arg) {
        Observable<String> observable = Observable.just(tellMeHello());

        observable.subscribe(s -> {
            Console.log(s);
        });
    }

    public static String tellMeHello() {
        Console.log("hello world created!");
        return "Hello World!";
    }
}