package it.aesys.courses.springboot.lesson1.models.mapperdto;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.ClassType;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapperDTO {


    public CharacterDTO toDto(Character character) {

        CharacterDTO dto = new CharacterDTO();
        dto.setUuid(character.getUuid());
        dto.setName(character.getName());
        dto.setLevel(character.getLevel());
        dto.setType(character.getType().toString());
        dto.setCostituion(character.getCostituion());
        dto.setDextery(character.getDextery());
        dto.setIntellect(character.getIntellect());
        dto.setStrength(character.getStrength());
        dto.setWisdom(character.getWisdom());

        return dto;
    }

    public Character toModel(CharacterDTO dto) {

        Character c = new Character();
        c.setUuid(dto.getUuid());
        c.setName(dto.getName());
        c.setLevel(dto.getLevel());
        c.setType(ClassType.WARRIOR);
        c.setCostituion(dto.getCostituion());
        c.setDextery(dto.getDextery());
        c.setIntellect(dto.getIntellect());
        c.setStrength(dto.getStrength());
        c.setWisdom(dto.getWisdom());
        return c;
    }
}
