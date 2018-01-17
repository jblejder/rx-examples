package rx.HelloWorld.operators;

import io.reactivex.Observable;

import static rx.Console.log;

public class _1_Map {
    public static void main(String[] arg) {
        Observable<String> observable = Observable.create(emitter -> {
            //log("new emitter");
            emitter.onNext("Hello");
            emitter.onComplete();
        });

        observable.map(s -> s + " World!")
                .subscribe(s -> log(s));

        observable.map(s -> 42).subscribe(s -> log(s));
    }
}
