package com.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer1 {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerid;

	private String answer;

    @ManyToOne
    private Question1 question1;

    public Answer1() {
        super();
    }

    public Answer1(int answerid, String answer, Question1 question1) {
		super();
		this.answerid = answerid;
		this.answer = answer;
		this.question1 = question1;
	}
    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question1 getQuestion1() {
        return question1;
    }

    public void setQuestion1(Question1 question1) {
        this.question1 = question1;
    }
    @Override
   	public String toString() {
   		return "Answer1 [answerid=" + answerid + ", answer=" + answer + ", question1=" + question1 + "]";
   	}
}