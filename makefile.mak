.DEFAULT_GOAL := ExamTester.class
JC = javac
Answer.class : Answer.java
		javac Answer.java
MCAnswer.class : MCAnswer.java Answer.class
		javac MCAnswer.java
MCSAAnswer.class : MCSAAnswer.java MCAnswer.class Answer.class
		javac MCSAAnswer.java
SAAnswer.class : SAAnswer.java Answer.class
		javac SAAnswer.java
Question.class : Question.java Answer.class
		javac Question.java
MCQuestion.class : MCQuestion.java Question.class Answer.class MCAnswer.class
		javac MCQuestion.java
MCSAQuestion.class : MCSAQuestion.java MCQuestion.class Question.class Answer.class MCAnswer.class
		javac MCSAQuestion.java
SAQuestion.class : SAQuestion.java Question.class Answer.class
		javac SAQuestion.java
Exam.class : Exam.java Question.class MCQuestion.class MCSAQuestion.class SAQuestion.class Answer.class MCAnswer.class MCSAAnswer.class SAAnswer.class
		javac Exam.java
ExamTester.class : ExamTester.java Exam.class Question.class MCQuestion.class MCSAQuestion.class SAQuestion.class Answer.class MCAnswer.class MCSAAnswer.class SAAnswer.class
		javac ExamTester.java
clean:
		rm *.class