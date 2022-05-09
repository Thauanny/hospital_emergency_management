package hospital_emergency_management;

import hospital_emergency_management.models.CollectionPersonEmergency;
import hospital_emergency_management.models.Person;
import hospital_emergency_management.utils.Util;
import java.time.Duration;
import java.util.Set;

/**
 * Trabalho de Thauanny Kyssy Ramos Pereira
 * Matricula: 20190000840
 */
public class App {

  public static void main(String[] args) {
    Set<String> emergencys = Set.of("Emergencia", "Muito Urgente", "Urgente");
    
    Person.personStream()
      .filter(person -> emergencys.contains(person.getSituation()))
      .buffer(Duration.ofSeconds(5))
      .map(list -> CollectionPersonEmergency.collectionPersonsEmergency(list))
      .subscribe(Util.subscriber());

    try {
      Thread.sleep(60000);
    } catch (InterruptedException ex) {
      System.out.println("");
    }
  }

  
}
