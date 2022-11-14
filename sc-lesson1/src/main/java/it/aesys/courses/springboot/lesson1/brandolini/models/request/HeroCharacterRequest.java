package it.aesys.courses.springboot.lesson1.brandolini.models.request;

import it.aesys.courses.springboot.lesson1.brandolini.models.mapperdto.HeroCharacterDTO;

public class HeroCharacterRequest {

    private HeroCharacterDTO heroCharacterDTO = new HeroCharacterDTO();

    public HeroCharacterRequest(){ super();}

    public HeroCharacterDTO getHeroCharacterDTO() {
        return heroCharacterDTO;
    }

    public void setHeroCharacterDTO(HeroCharacterDTO heroCharacterDTO) {
        this.heroCharacterDTO = heroCharacterDTO;
    }
}
