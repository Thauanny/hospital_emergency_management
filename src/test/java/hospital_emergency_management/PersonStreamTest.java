package hospital_emergency_management;

import org.junit.Test;

import hospital_emergency_management.models.Person;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import org.junit.jupiter.api.Assertions;

public class PersonStreamTest {
    
    @Test
    public void personStreamTest(){
        Flux<Person> persons = Person.personStream();

        StepVerifier.create(persons).assertNext(p -> Assertions.assertNotNull(p.getNameAgeSymptomsSituationHour()));
    }
}
