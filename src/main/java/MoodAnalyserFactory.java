import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    // THE SET FIELD VALUE IN THIS METHOD
    public static String setFieldMoodAnalyser(MoodAnalyzer mood,String fieldName,String fieldValue){
        try{
            Field field = mood.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(mood,fieldValue);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    // THAT CAN BE RETURN MESSAGE
    public static String moodAnalyzer(MoodAnalyzer message,String methodName) throws MoodAnalysisException {
        try {
            return (String)message.getClass().getMethod(methodName).invoke(message);
        } catch (Exception e) { }return null;
    }
    // THAT CAN BE A RETURN CALSS OBJECT
    public static Constructor<?> getConstructor(String className,Class methodName) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            return moodAnalyzer.getConstructor(methodName);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }
    }
    // THAT CAN BE A RETURN CALSS OBJECT WITH PARAMETER CONSTRUCTOR
    public static Object getParameterizConstructor(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> constructorMood = moodAnalyzer.getConstructor(methodName);
            return constructorMood.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return ("mood");
    }
    // THAT CAN BE A RETURN CALSS OBJECT BUT CLASS NAME IS IMPROPER WITH PARAMETER
    public static Object getClassNameImproperWithParameter(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> construct = moodAnalyzer.getConstructor(methodName);
            return construct.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return(mood);
    }
    // THAT CAN BE A RETURN CONSTRUCTOR INSTANCE
    public static <MoodAnalyzer> MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzer.getConstructor();
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
