package it.aesys.courses.springboot.lesson1.models.mapperdto;


public class CharacterDTO {


    private String uuid;
    private String name;
    private Integer level;


    private Integer strength;
    private Integer costituion;
    private Integer dextery;
    private Integer wisdom;
    private Integer Intellect;

    private String type;

    public CharacterDTO() {
    }

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getCostituion() {
        return costituion;
    }

    public void setCostituion(Integer costituion) {
        this.costituion = costituion;
    }

    public Integer getDextery() {
        return dextery;
    }

    public void setDextery(Integer dextery) {
        this.dextery = dextery;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getIntellect() {
        return Intellect;
    }

    public void setIntellect(Integer intellect) {
        Intellect = intellect;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", costituion=" + costituion +
                ", dextery=" + dextery +
                ", wisdom=" + wisdom +
                ", Intellect=" + Intellect +
                ", type='" + type + '\'' +
                '}';
    }
}
