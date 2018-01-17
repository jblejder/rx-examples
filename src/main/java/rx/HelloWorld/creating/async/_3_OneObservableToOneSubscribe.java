package rx.HelloWorld.creating.async;

import io.reactivex.Observable;

import static rx.Console.log;

public class _3_OneObservableToOneSubscribe {

    public static void main(String[] arg) {
        Observable<String> observable = Observable.create(emitter -> {
            String hello = tellMeHello();

            emitter.onNext(hello);
            emitter.onComplete();
        });

        log("first subscribe");
        observable.subscribe(s -> {
            log("in first subscribe");
            log(s);
        });

        log("second subscribe");
        observable.subscribe(s -> {
            log("in second subscribe");
            log(s);
        });
    }

    public static String tellMeHello() {
        log("new hello created");
        return "Hello World!";
    }
}
