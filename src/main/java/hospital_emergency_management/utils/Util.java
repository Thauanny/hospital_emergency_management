package hospital_emergency_management.utils;

import java.util.function.Consumer;

import com.github.javafaker.Faker;

import org.reactivestreams.Subscriber;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError(){
        return o -> System.out.println("ERROR: " + o.getMessage());
    }

    public static Runnable OnComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber();
    }
}
