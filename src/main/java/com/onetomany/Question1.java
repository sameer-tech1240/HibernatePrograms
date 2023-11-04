package com.onetomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Question1 {
   
	@Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionid;

    private String question;

    @OneToMany(mappedBy = "question1", cascade = CascadeType.ALL) // Use mappedBy to specify the inverse side of the relationship.
    private List<Answer1> answer1;

    public Question1() {
        super();
    }
    public Question1(int questionid, String question, List<Answer1> answer1) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.answer1 = answer1;
	}

	@Override
	public String toString() {
		return "Question1 [questionid=" + questionid + ", question=" + question + ", answer1=" + answer1 + "]";
	}


    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer1> getAnswer1() {
        return answer1;
    }

    public void setAnswer1(List<Answer1> answer1) {
        this.answer1 = answer1;
    }
}

