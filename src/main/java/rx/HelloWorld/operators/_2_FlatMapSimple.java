package rx.HelloWorld.operators;

import io.reactivex.Observable;

import static rx.Console.log;

public class _2_FlatMapSimple {

    static class Simple {
        public static void main(String[] arg) {
            Observable<String> observable = Observable.create(emitter -> {
                log("new emitter");
                emitter.onNext("Hello");
                emitter.onNext("Hello");
                emitter.onComplete();
            });

            observable
                    .flatMap(s -> {
                        log("in flat map");
                        return Observable.just(s + " World!");
                    })
                    .subscribe(s -> log(s));
        }
    }


    static class Async {
        public static void main(String[] arg) {
            Observable<String> observable = Observable.create(emitter -> {
                log("new emitter");
                emitter.onNext("Hello");
                emitter.onNext("Hello");
                emitter.onComplete();
            });

            observable
                    .flatMap(s -> {
                        log("in flat map");
                        return Observable.<String>create(emitter -> {
                            emitter.onNext(s + " World");
                            emitter.onComplete();
                        });
                    })
                    .subscribe(s -> log(s));
        }
    }

    static class COMBO_BREAKER {
        public static void main(String[] arg) {
            Observable<String> observable = Observable.create(emitter -> {
                log("new emitter");
                emitter.onNext("Hello");
                emitter.onNext("Hello");
                emitter.onComplete();
            });

            observable
                    .flatMap(s -> {
                        log("in flat map");
                        return Observable.<String>create(emitter -> {
                            emitter.onNext(s + " World");
                            emitter.onNext("dupa:)");
                            emitter.onComplete();
                        });
                    })
                    .subscribe(s -> log(s));
        }
    }

    static class MASSIVE_COMBO_BREAKER {
        public static void main(String[] arg) {
            Observable<String> observable = Observable.create(emitter -> {
                log("new emitter");
                emitter.onNext("Hello");
                emitter.onNext("Hello");
                emitter.onComplete();
            });

            observable
                    .flatMap(s -> {
                        log("in flat map");
                        return Observable.<String>create(emitter -> {
                            for (int i = 0; i < s.length(); i++) {
                                emitter.onNext(String.valueOf(s.charAt(i)));
                            }
                            emitter.onNext("Koniec");
                            emitter.onComplete();
                        });
                    })
                    .subscribe(s -> log(s));
        }
    }
}
