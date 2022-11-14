package it.aesys.courses.springboot.lesson1.vizzarro.components;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.vizzarro.components.exceptions.ComponentException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class CharacterComponent {

    private Map<String, Character> mapCharacter = new HashMap<>();

    public Character create(Character c) throws ComponentException {
        if (!mapCharacter.containsKey(c.getUuid())) {
            mapCharacter.put(c.getUuid(), c);
            return mapCharacter.get(c.getUuid());
        }
        ComponentException ex = new ComponentException();
        ex.setStatusCode(400);
        throw ex;
    }

    public Character get(String uuid) throws ComponentException {

        if (mapCharacter.containsKey(uuid)) {
            return mapCharacter.get(uuid);
        }
        ComponentException ex = new ComponentException();
        ex.setStatusCode(404);
        throw ex;
    }

<<<<<<< HEAD

=======
    public void delete(String uuid) throws ComponentException {

        if (mapCharacter.containsKey(uuid)) {
            mapCharacter.remove(uuid);
        }
        ComponentException ex = new ComponentException();
        ex.setStatusCode(404);
        throw ex;

    }

    public Character update(Character c) throws ComponentException {

        if (mapCharacter.containsKey(c.getUuid())) {
           return mapCharacter.put(c.getUuid(),c);
        }
        ComponentException ex = new ComponentException();
        ex.setStatusCode(404);
        throw ex;
    }

    public Collection<Character> findAll() throws ComponentException {

        return mapCharacter.values();

    }
>>>>>>> bd44ebd6d8e17a7cfa070e62e7e266a23d5cfc09
}