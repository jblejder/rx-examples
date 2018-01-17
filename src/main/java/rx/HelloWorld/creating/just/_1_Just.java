package rx.HelloWorld.creating.just;

import io.reactivex.Observable;
import rx.Console;

public class _1_Just {

    public static void main(String[] arg) {
        Observable<String> observable = Observable.just("Hello World");
        observable.subscribe(s -> {
            Console.log(s);
        });
    }
}
