package pt.isec.pa.aulas.organisms.model.data;

import pt.isec.pa.aulas.organisms.gameengine.IGameEngine;
import pt.isec.pa.aulas.organisms.gameengine.IGameEngineEvolve;
import pt.isec.pa.aulas.organisms.model.ModelLog;
import pt.isec.pa.aulas.organisms.model.data.Environment;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class EnvironmentManager implements IGameEngineEvolve {
    public static final String FILE = "files/environment.txt";
    public static final String LOGFILE = "files/logs.txt";
    Environment environment;

    public EnvironmentManager() {
        environment = readFile(FILE);
        if (environment!=null) return;
        this.environment = new Environment(10,10);
        for(int i = 0;i<10;i++) {
            int y = (int)(Math.random()*10);
            int x = (int)(Math.random()*10);
            environment.addOrganism(new Virus(environment),y,x);
        }
        for(int i = 0;i<10;i++) {
            int y = (int)(Math.random()*10);
            int x = (int)(Math.random()*10);
            environment.addOrganism(new Evolver(environment),y,x);
        }
    }

    public boolean onlyOneSpecies() {
        return environment.onlyOneSpecies();
    }

    private static Environment readFile(String filepath) {
        Environment environment = null;
        FileReader fileReader = null;
        try {
            File file = new File(filepath);                             //cria a class de ficheiro mas sem nada
            if (!file.exists()) return null;
            fileReader = new FileReader(file);               //usado para ficheiros de texto apenas
            BufferedReader bf = new BufferedReader(fileReader);         //faz com que seja possivel ler linha a linha p.e.
            Scanner sc = new Scanner(bf);
            sc.useDelimiter(",|\\n");
            int h=sc.nextInt();
            int w=sc.nextInt();
            environment = new Environment(h,w);
            while (sc.hasNext()){
                char c = sc.next().charAt(0);
                int y = sc.nextInt();
                int x = sc.nextInt();
                Organism organism = switch (c) {
                    case Evolver.SYMBOL -> new Evolver(environment);
                    case Virus.SYMBOL -> new Virus(environment);
                    default -> null;
                };
                environment.addOrganism(organism,y,x);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e){

                }
            }
        }
        return environment;
    }
    private void saveLogs(){
//        FileWriter fw;
//        PrintWriter pw;
        try (                                                       //melhor maneira de fazer porque nao é preciso close
                FileWriter fw = new FileWriter(LOGFILE,true);//nao esquecer este true senao apaga tudo no file
                PrintWriter pw = new PrintWriter(fw);
                ){
            List<String> lst = ModelLog.getInstance().getLog();
            for (String msg : lst)
                pw.println(msg);
            ModelLog.getInstance().reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[][] getEnvironment() {
        return environment.getEnvironment();
    }

    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        if (environment == null) return;
        environment.evolve();
        saveLogs();
    }
}
