package hospital_emergency_management.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import lombok.ToString;

@ToString
public class CollectionPersonEmergency {
    private Map<String,List<String>> personEmergency;

    public CollectionPersonEmergency(Map<String,List<String>> personEmergency){
        this.personEmergency = personEmergency;
    }

    public Map<String,Collection<List<String>>> getFinalData(){
        return Map.of("", personEmergency.values());
    }
}
