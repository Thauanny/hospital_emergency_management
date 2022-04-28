package hospital_emergency_management.utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object>{
    private String name = "";

    public DefaultSubscriber(String name){
        this.name = name + " - ";
    }

    public DefaultSubscriber(){
       
    }

    @Override
    public void onComplete() {
        System.out.println(name + "Completed");
        
    }

    @Override
    public void onError(Throwable arg0) {
        System.out.println(name + "ERROR: " + arg0.getMessage());
        
    }

    @Override
    public void onNext(Object arg0) {
        System.out.println(name + "Received: " + arg0);
        
    }

    @Override
    public void onSubscribe(Subscription arg0) {
        arg0.request(Long.MAX_VALUE);
        
    }
    
}
