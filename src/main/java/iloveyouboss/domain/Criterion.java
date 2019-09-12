package iloveyouboss.domain;

public class Criterion implements Scoreable {
    private int score;
    private Weight weight;
    private Answer answer;

    public Criterion(Answer answer, Weight weight){
        this.answer = answer;
        this.weight = weight;
    }

    public Answer getAnswer(){return  answer;}
    public Weight getWeight(){return weight;}

    public void setScore(int score){this.score = score;}
    public int getScore(){
        return score;
    }
}
