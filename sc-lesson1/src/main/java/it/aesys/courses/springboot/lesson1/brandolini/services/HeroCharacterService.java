package it.aesys.courses.springboot.lesson1.brandolini.services;

import it.aesys.courses.springboot.lesson1.brandolini.components.HeroCharacterComponent;
import it.aesys.courses.springboot.lesson1.brandolini.components.exceptions.ComponentExceptionBrandolini;
import it.aesys.courses.springboot.lesson1.brandolini.models.ClassType;
import it.aesys.courses.springboot.lesson1.brandolini.models.HeroCharacter;
import it.aesys.courses.springboot.lesson1.brandolini.models.HeroCharacterName;
import it.aesys.courses.springboot.lesson1.brandolini.models.Race;
import it.aesys.courses.springboot.lesson1.brandolini.models.mapperdto.HeroCharacterDTO;
import it.aesys.courses.springboot.lesson1.brandolini.models.mapperdto.HeroCharacterMapperDTO;
import it.aesys.courses.springboot.lesson1.brandolini.services.exceptions.ServiceExceptionBrandolini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
public class HeroCharacterService {

    private HeroCharacterMapperDTO heroCharacterMapperDTO;
    private HeroCharacterComponent heroCharacterMapDao;



    @Autowired
    public HeroCharacterService(HeroCharacterComponent heroCharacterMapDao, HeroCharacterMapperDTO heroCharacterMapperDTO){
        this.heroCharacterMapDao = heroCharacterMapDao;
        this.heroCharacterMapperDTO = heroCharacterMapperDTO;
    }

    public HeroCharacterDTO create(HeroCharacterDTO heroCharacterDto) throws ServiceExceptionBrandolini {
        heroCharacterDto.toString();
        try {
            return heroCharacterMapperDTO.toDto(heroCharacterMapDao.create(heroCharacterMapperDTO.toModel(heroCharacterDto)));
        }
        catch (ComponentExceptionBrandolini e){
            ServiceExceptionBrandolini ex = new ServiceExceptionBrandolini();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public HeroCharacterDTO get(String uuid) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        try {
            return heroCharacterMapperDTO.toDto(heroCharacterMapDao.getCharacter(uuid)) ;

        }
        catch (ComponentExceptionBrandolini e){
            ServiceExceptionBrandolini ex = new ServiceExceptionBrandolini();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public Collection<HeroCharacterDTO> getAll() throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        //try {
            Collection< HeroCharacterDTO> allHeroCharactersDto = new ArrayList<>();

            Collection<HeroCharacter> allHeroCharacters = heroCharacterMapDao.findAllCharacters();

            allHeroCharacters.forEach(x -> allHeroCharactersDto.add(heroCharacterMapperDTO.toDto(x)) );

            return allHeroCharactersDto;

        //}
        //catch (ServiceExceptionBrandolini ex) {
          //  throw ex;

        //}
    }



    public HeroCharacterDTO update(HeroCharacterDTO heroCharacterDTO) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        try {
            if (heroCharacterMapDao.getCharacter(heroCharacterMapperDTO.toModel(heroCharacterDTO).getUuid()) !=null) {
                HeroCharacter updatedHeroCharacter = heroCharacterMapperDTO.toModel(heroCharacterDTO);
                heroCharacterMapDao.updateCharacter(updatedHeroCharacter);
                return heroCharacterMapperDTO.toDto(updatedHeroCharacter);
            }
            else {
                ServiceExceptionBrandolini exc = new ServiceExceptionBrandolini();
                exc.setStatusCode(404);
                throw exc;
            }
        }
        catch (ComponentExceptionBrandolini e){
            ServiceExceptionBrandolini ex = new ServiceExceptionBrandolini();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public void delete(String uuid) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        try {
             if (heroCharacterMapperDTO.toDto(heroCharacterMapDao.getCharacter(uuid)).getUuid()   != null){
                 HeroCharacter characterToDelete = new HeroCharacter();
                 characterToDelete = heroCharacterMapDao.getCharacter(uuid);
                 //characterToDelete.setLevel(1);
                 heroCharacterMapDao.deleteCharacter(characterToDelete);
             }
             else {
                 ServiceExceptionBrandolini exc = new ServiceExceptionBrandolini();
                 exc.setStatusCode(404);
                 throw exc;
             }
        }
        catch (ComponentExceptionBrandolini e){
            ServiceExceptionBrandolini ex = new ServiceExceptionBrandolini();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public HeroCharacterDTO random() throws ServiceExceptionBrandolini {
        Random random = new Random();

        HeroCharacterDTO randomHeroCharacterDto = new HeroCharacterDTO();

        //Map<String, HeroCharacter> sortedHeroCharacters = new TreeMap(heroCharacterMapDao.returnHashmap());

        TreeMap<Integer, HeroCharacter> sortedHeroCharacters = new TreeMap();

        heroCharacterMapDao.returnHashmap().forEach((s , c)-> {
        sortedHeroCharacters.put(Integer.valueOf(s) , c);
        });
        Integer lastEntry;
        if (sortedHeroCharacters.lastKey() != null) {
             lastEntry = (sortedHeroCharacters.lastKey() + 1);
        }
        else {
            lastEntry = 0;
        }
        randomHeroCharacterDto.setUuid(Integer.toString(lastEntry ));
        //randomHeroCharacterDto.setName(HeroCharacterName.values()[random.nextInt(1,35)].name());
        randomHeroCharacterDto.setName(HeroCharacterName.values()[(int) (Math.random()*30+1)].name());
        //randomHeroCharacterDto.setClassType(ClassType.values()[random.nextInt(0,7)]);
        randomHeroCharacterDto.setClassType(ClassType.values()[(int) (Math.random()*3+1)]);
        //randomHeroCharacterDto.setRace(Race.values()[random.nextInt(0,4)]);
        randomHeroCharacterDto.setRace(Race.values()[(int) (Math.random()*3+1)]);
        //randomHeroCharacterDto.setStrength(random.nextInt(1,19));
        randomHeroCharacterDto.setStrength((int) (Math.random()*18+1));
       // randomHeroCharacterDto.setIntelligence(random.nextInt(1,19));
        randomHeroCharacterDto.setIntelligence((int) (Math.random()*18+1));

        //randomHeroCharacterDto.setWisdom(random.nextInt(1,19));
        randomHeroCharacterDto.setWisdom((int) (Math.random()*18+1));

        //randomHeroCharacterDto.setDexterity(random.nextInt(1,19));
        randomHeroCharacterDto.setDexterity((int) (Math.random()*18+1));

        //randomHeroCharacterDto.setConstitution(random.nextInt(1,19));
        randomHeroCharacterDto.setConstitution((int) (Math.random()*18+1));

        //randomHeroCharacterDto.setCharisma(random.nextInt(1,19));
        randomHeroCharacterDto.setCharisma((int) (Math.random()*18+1));

        return create(randomHeroCharacterDto);

    }


}
