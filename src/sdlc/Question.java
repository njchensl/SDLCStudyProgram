/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlc;

/**
 *
 * @author frche1699
 */
public class Question {

    private String question;
    private String options[];
    private String correctOption;

    public Question(String q, String[] ops, String correct) {
        question = q;
        options = ops;
        correctOption = correct;
    }

    public String getOption(int n) {
        return options[n];
    }

    public void setOption(int n, String s) {
        options[n] = s;
    }
    
    public void setOptions(String s[]) {
        options = s;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String s) {
        question = s;
    }

    public boolean isCorrect(String s) {
        return s.equals(correctOption);
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String s) {
        correctOption = s;
    }
    
    @Override
    public String toString() {
        return "Question: " + question + "\n"
                + "Options:\n"
                + options[0] + "\n"
                + options[1] + "\n"
                + options[2] + "\n"
                + options[3] + "\n"
                + "Correct Option:\n"
                + correctOption;
    }
}
