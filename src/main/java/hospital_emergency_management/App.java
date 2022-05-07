package hospital_emergency_management;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import hospital_emergency_management.models.CollectionPersonEmergency;
import hospital_emergency_management.models.Person;
import hospital_emergency_management.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Set<String> emergencys = Set.of("Emergencia", "Muito Urgente", "Urgente");
        personStream().filter(person -> emergencys.contains(person.getSituation())).buffer(Duration.ofSeconds(5))
                .map(list -> collectionPersonsEmergency(list)).subscribe(Util.subscriber());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            System.out.println("");
        }
    }

    private static CollectionPersonEmergency collectionPersonsEmergency(List<Person> persons) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Pacientes de urgencia para encaminhamento: ");

        Map<String, List<String>> map = persons.stream()
                .collect(Collectors.toMap(Person::getId, Person::getNameSiAgeSymptomsSituation));
                System.out.println("------------------------------------------------------------------");
        return new CollectionPersonEmergency(map);
        
    }

    private static Flux<Person> personStream() {

        return Flux.interval(Duration.ofMillis(200)).map(i -> {
            Person person = new Person();
            System.out.print("Paciente  recem chegado: ");
            System.out.println(person.getNameSiAgeSymptomsSituation());
            return person;
        });
    }

}
