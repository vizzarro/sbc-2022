package it.aesys.courses.springboot.lesson1.models;

public class Character {

    private String name;
    private Integer level;
    private Integer strength;
    private Integer costituion;
    private SizeType size;
    private Integer dextery;
    private Integer wisdom;
    private Integer charsim;
    private Integer Intellect;

    private ClassType type;


    public Character() {
        super();
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

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
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

    public Integer getCharsim() {
        return charsim;
    }

    public void setCharsim(Integer charsim) {
        this.charsim = charsim;
    }

    public Integer getIntellect() {
        return Intellect;
    }

    public void setIntellect(Integer intellect) {
        Intellect = intellect;
    }

    public ClassType getType() {
        return type;
    }

    public void setType(ClassType type) {
        this.type = type;
    }
}
