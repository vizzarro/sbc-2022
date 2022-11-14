package it.aesys.courses.springboot.lesson1.brandolini.components;

import it.aesys.courses.springboot.lesson1.brandolini.components.exceptions.ComponentExceptionBrandolini;
import it.aesys.courses.springboot.lesson1.brandolini.models.HeroCharacter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class HeroCharacterComponent {

    Map <String, HeroCharacter> heroCharacterMap = new HashMap<>();

    public HeroCharacter create(HeroCharacter heroCharacter) throws ComponentExceptionBrandolini {

        if (!heroCharacterMap.containsKey(heroCharacter.getUuid())){

            heroCharacterMap.put(heroCharacter.getUuid(), heroCharacter);
            return heroCharacterMap.get(heroCharacter.getUuid());

        }
        ComponentExceptionBrandolini ex = new ComponentExceptionBrandolini();
        ex.setStatusCode(400);
        throw ex;
    }

    public HeroCharacter getCharacter(String uuid) throws ComponentExceptionBrandolini {
        if (heroCharacterMap.containsKey(uuid) ){
            return heroCharacterMap.get(uuid);
        }
        ComponentExceptionBrandolini ex = new ComponentExceptionBrandolini();
        ex.setStatusCode(404);
        throw ex;
    }

    public void deleteCharacter(HeroCharacter heroCharacter) throws ComponentExceptionBrandolini {
        if (heroCharacterMap.containsKey(heroCharacter.getUuid())){
            heroCharacterMap.remove(heroCharacter.getUuid());
        }
        else {
            ComponentExceptionBrandolini ex = new ComponentExceptionBrandolini();
            ex.setStatusCode(404);
            throw ex;
        }
    }

    public HeroCharacter updateCharacter(HeroCharacter heroCharacter) throws ComponentExceptionBrandolini {

        if (heroCharacterMap.containsKey(heroCharacter.getUuid())){

            return heroCharacterMap.put(heroCharacter.getUuid(), heroCharacter);
        }
        ComponentExceptionBrandolini ex = new ComponentExceptionBrandolini();
        ex.setStatusCode(404);
        throw ex;

    }

    public Collection<HeroCharacter> findAllCharacters(){

        return heroCharacterMap.values();
    }

    public Map<String, HeroCharacter> returnHashmap(){
        return heroCharacterMap;
    }

}
