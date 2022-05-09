package hospital_emergency_management;

import java.time.Duration;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import hospital_emergency_management.models.CollectionPersonEmergency;
import hospital_emergency_management.models.Person;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class CollectionPersonEmergencyTest {
        
   

      @Test
      public void CollectStreamTest(){
        Set<String> emergencys = Set.of("Emergencia", "Muito Urgente", "Urgente");

        Flux<Object> colePersons = Person.personStream()
        .filter(person -> emergencys.contains(person.getSituation()))
        .buffer(Duration.ofSeconds(5))
        .map(list -> CollectionPersonEmergency.collectionPersonsEmergency(list));
    
  
          StepVerifier.create(colePersons).assertNext(p -> Assertions.assertNotNull(p));
      }
    
}
