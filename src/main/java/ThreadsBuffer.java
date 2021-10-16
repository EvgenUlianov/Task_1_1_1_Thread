import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadsBuffer {

    private Map<String, Boolean> sleepComands;

    private ThreadsBuffer(){
        this.sleepComands = new HashMap<>();
    };

    private static class Holder {
        public static final ThreadsBuffer threadsBuffer = new ThreadsBuffer();
    }

    public static ThreadsBuffer get()  {
        return Holder.threadsBuffer;
    }

    public void setSleepComand(String key, Boolean value){
        sleepComands.put(key, value);
    }

    public Boolean getSleepComand(String key){
        Boolean value = sleepComands.get(key);
        if (value == null)
            return Boolean.FALSE;
        return value;
    }

}
