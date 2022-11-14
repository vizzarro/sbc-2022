package it.aesys.courses.springboot.lesson1.models.request;

import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;

public class CharacterRequest {

    private CharacterDTO character = new CharacterDTO();

    public CharacterRequest() {
        super();
    }

    public CharacterDTO getCharacter() {
        return character;
    }

    public void setCharacter(CharacterDTO character) {
        this.character = character;
    }
}
