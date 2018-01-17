package rx.HelloWorld.creating.async;

import io.reactivex.Observable;
import rx.Console;

public class _2_Short {
    public static void main(String[] arg) {

        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Hello World!");
            emitter.onComplete();
        });

        observable.subscribe(s -> Console.log(s));
    }
}
