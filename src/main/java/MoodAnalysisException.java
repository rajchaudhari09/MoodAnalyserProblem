class MoodAnalysisException extends Exception {
    enum MyException_Type{
        EMPTY,NULL,CLASS_NOT_FOUND,METHOD_NOT_FOUND;
    }
    MyException_Type type;
    MyException_Type exceptionMessage;
    MoodAnalysisException(MyException_Type type,String message) {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}