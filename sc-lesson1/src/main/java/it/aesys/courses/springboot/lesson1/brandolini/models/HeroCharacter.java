package it.aesys.courses.springboot.lesson1.brandolini.models;

public class HeroCharacter {

    private String uuid;
    private String name;
    private ClassType classType;
    private Race race;
    private Integer strength;
    private Integer intelligence;
    private Integer wisdom;
    private Integer dexterity;
    private Integer constitution;
    private Integer charisma;
    private Integer level;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassType getClassType() {
        return classType;
    }

    @Override
    public String toString(){
        return  "heroCharacter{"+
                " uuid " + uuid +
                " name " + name +
                " classType " + classType+
                " race " + race +
                " level " + level +
                " strength " + strength +
                " intelligence " + intelligence +
                " constitution " + constitution +
                " dexterity "+ dexterity+
                " wisdom " + wisdom+
                " charisma "+ charisma+
                "}";
    }



    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
