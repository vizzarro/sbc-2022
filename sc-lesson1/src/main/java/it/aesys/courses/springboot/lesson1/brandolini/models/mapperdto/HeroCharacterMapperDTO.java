package it.aesys.courses.springboot.lesson1.brandolini.models.mapperdto;

import it.aesys.courses.springboot.lesson1.brandolini.controllers.HeroCharacterController;
import it.aesys.courses.springboot.lesson1.brandolini.models.ClassType;
import it.aesys.courses.springboot.lesson1.brandolini.models.HeroCharacter;
import it.aesys.courses.springboot.lesson1.brandolini.models.Race;
import org.springframework.stereotype.Component;

@Component
public class HeroCharacterMapperDTO {

    public HeroCharacterDTO toDto(HeroCharacter heroCharacter){

        HeroCharacterDTO heroCharacterDTO = new HeroCharacterDTO();

        heroCharacterDTO.setUuid(heroCharacter.getUuid());
        heroCharacterDTO.setName(heroCharacter.getName());
        heroCharacterDTO.setClassType(heroCharacter.getClassType());
        heroCharacterDTO.setRace(heroCharacter.getRace());
        heroCharacterDTO.setStrength(heroCharacter.getStrength());
        heroCharacterDTO.setIntelligence(heroCharacter.getIntelligence());
        heroCharacterDTO.setWisdom(heroCharacter.getWisdom());
        heroCharacterDTO.setDexterity(heroCharacter.getDexterity());
        heroCharacterDTO.setConstitution(heroCharacter.getConstitution());
        heroCharacterDTO.setCharisma(heroCharacter.getCharisma());

        return heroCharacterDTO;
    }

    public HeroCharacter toModel(HeroCharacterDTO heroCharacterDTO){

        HeroCharacter heroCharacter = new HeroCharacter();
        heroCharacter.setUuid(heroCharacterDTO.getUuid());
        heroCharacter.setName(heroCharacterDTO.getName());
        heroCharacter.setClassType(heroCharacterDTO.getClassType());
        heroCharacter.setRace(heroCharacterDTO.getRace());
        heroCharacter.setStrength(heroCharacterDTO.getStrength());
        heroCharacter.setIntelligence(heroCharacterDTO.getIntelligence());
        heroCharacter.setWisdom(heroCharacterDTO.getWisdom());
        heroCharacter.setDexterity(heroCharacterDTO.getDexterity());
        heroCharacter.setConstitution(heroCharacterDTO.getConstitution());
        heroCharacter.setCharisma(heroCharacterDTO.getCharisma());

        return heroCharacter;
    }

}
