package it.aesys.courses.springboot.model;

public class Problem {

    private ProblemType problemType;

    public Problem(){

    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

}
