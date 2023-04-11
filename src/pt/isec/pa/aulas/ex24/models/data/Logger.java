package pt.isec.pa.aulas.ex24.models.data;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance = null;

    public static Logger getInstance() {
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }
    private ArrayList<String> logs;
    private Logger(){
        logs = new ArrayList<>();
    }

    public void log(String str){
        logs.add(str);
    }
    public List<String> getLogs(){
        return new ArrayList<>(logs);
    }

    public void reset(){
        logs.clear();
    }
}
