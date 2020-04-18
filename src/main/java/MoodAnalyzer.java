import java.util.Objects;

public class MoodAnalyzer {
    private String message;

    public static void main(String[] args) {
        System.out.println("***************Welcome To Mood Analyzer***************");
        MoodAnalyzer moodAnalyzerObject = new MoodAnalyzer();
    }

    // THAT CAN BE A METHOD RETURN IS MOOD
    public String moodAnalyzer() throws MoodAnalysisException {
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.EMPTY, "You entered empty,please enter valid mood");
            }
            if (message.contains("sad")) {
                return ("sad");
            } else if (message.contains("happy")) {
                return ("happy");
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NULL, "You entered null,please enter valid mood");
        }
        return (null);
    }

    // THAT CAN BE A DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {
    }

    // THAT CAN BE A PARAMETERIZED CONSTRUCTOR
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    // THAT CAN BE A CHECK EQUAL OR NOT EQUAL TWO OBJECT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }
}
