package domains;

/**
 * Created by User on 3/17/2017.
 */
public class UserAnswer {
    int uid;
    int userAns;
    int marks;
    int qid;
    String question;
    int correctAns;

    String correctAnswerSt;
    String chosenAnswerSt;

    public String getCorrectAnswerSt() {
        return correctAnswerSt;
    }

    public void setCorrectAnswerSt(String correctAnswerSt) {
        this.correctAnswerSt = correctAnswerSt;
    }

    public String getChosenAnswerSt() {
        return chosenAnswerSt;
    }

    public void setChosenAnswerSt(String chosenAnswerSt) {
        this.chosenAnswerSt = chosenAnswerSt;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getUserAns() {
        return userAns;
    }

    public void setUserAns(int userAns) {
        this.userAns = userAns;
    }
}
