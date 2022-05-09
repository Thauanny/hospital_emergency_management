package hospital_emergency_management.models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import hospital_emergency_management.utils.Util;
import reactor.core.publisher.Flux;

public class Person{
    private String id;
    private String name;
    private String age;
    private String symptoms;
    private String situation;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Person(){
        String id = UUID.randomUUID().toString();
        String[] arr={"Emergencia", "Muito Urgente","Urgente", "Pouco Urgente", "Não urgente"};
        int rnd =  Util.faker().random().nextInt(arr.length);
        String  symptoms = Util.faker().medical().symptoms();
        int age = Util.faker().number().numberBetween(1, 100);
        String name = Util.faker().name().fullName();

        
        this.name = name;
        this.age = Integer.toString(age);
        this.situation = arr[rnd];
        this.symptoms = symptoms;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    public String getSymptoms(){
        return this.symptoms;
    }
    public String getSituation(){
        return this.situation;
    }

    public List<String> getNameAgeSymptomsSituationHour(){
        return Arrays.asList(this.name,  this.age, this.symptoms, this.situation, Integer.toString(this.localDateTime.getHour())+"h"+ Integer.toString(this.localDateTime.getMinute())+"M" );
    }

    public String getId(){
        return this.id;
    }


    public static Flux<Person> personStream() {
        return Flux
          .interval(Duration.ofMillis(200))
          .map(
            i -> {
              Person person = new Person();
              System.out.print("Paciente  recem chegado: ");
              System.out.println(person.getNameAgeSymptomsSituationHour());
              return person;
            }
          );
      }
}
