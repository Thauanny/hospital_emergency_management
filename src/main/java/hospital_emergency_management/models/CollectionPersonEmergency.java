package hospital_emergency_management.models;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.ToString;

@ToString
public class CollectionPersonEmergency {

  private Map<String, List<String>> personEmergency;

  public CollectionPersonEmergency(Map<String, List<String>> personEmergency) {
    this.personEmergency = personEmergency;
  }

  public Map<String, Collection<List<String>>> getFinalData() {
    return Map.of("", personEmergency.values());
  }

  public static CollectionPersonEmergency collectionPersonsEmergency(
    List<Person> persons
  ) {
    System.out.println(
      "------------------------------------------------------------------"
    );
    System.out.println("Pacientes de urgencia para encaminhamento: ");

    Map<String, List<String>> map = persons
      .stream()
      .collect(
        Collectors.toMap(Person::getId, Person::getNameAgeSymptomsSituationHour)
      );
    System.out.println(
      "------------------------------------------------------------------"
    );
    return new CollectionPersonEmergency(map);
  }
}
