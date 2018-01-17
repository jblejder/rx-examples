package rx.HelloWorld.creating.async;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static rx.Console.log;

public class _4_share {
    public static void main(String[] arg) {
        Observable<String> observable = Observable.create(emitter -> {
            String hello = tellMeHello();

            log("hello emitted");
            emitter.onNext(hello);
            emitter.onComplete();
        });

        Observable<String> sharedObservable = observable.delay(2, TimeUnit.MILLISECONDS).share();

        log("first subscribe");
        sharedObservable.subscribe(s -> {
            log("in first subscribe");
            log(s);
        });

        log("second subscribe");
        sharedObservable.subscribe(s -> {
            log("in second subscribe");
            log(s);
        });
    }

    public static String tellMeHello() {
        log("new hello created");
        return "Hello World!";
    }
}
