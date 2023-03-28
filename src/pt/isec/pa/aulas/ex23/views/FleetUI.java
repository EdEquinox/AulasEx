package pt.isec.pa.aulas.ex23.views;

import pt.isec.pa.aulas.ex23.models.Carga;
import pt.isec.pa.aulas.ex23.models.Fleet;
import pt.isec.pa.aulas.ex23.models.Ligeiro;
import pt.isec.pa.aulas.ex23.models.PesadoPass;
import pt.isec.pa.aulas.utils.PAInput;

public class FleetUI {
    Fleet fleet;
    public FleetUI(Fleet fleet) {
        this.fleet = fleet;
    }

    void addVehicle() {
        int escolha = PAInput.readInt("Ligeiro (1), Pesado de passageiros (2) ou Mercadorias (3)? ");
        if (escolha == 1){
            addLigeiro();
        } else if (escolha == 2) {
            addPesPas();
        } else {
            addPesMerc();
        }
    }

    private void addPesMerc() {
        String matricula = PAInput.readString("Matricula: ",false);
        int ano = PAInput.readInt("Ano de contrução: ");
        int maxLoad = PAInput.readInt("Maximo de carga: ");
        Carga car = new Carga(matricula,ano,maxLoad);
        if (!fleet.addCar(car)){
            System.out.println("Erro a adicionar carro!");
        } else {
            System.out.println("Carro adicionado com sucesso!");
        }
    }

    private void addPesPas() {
        String matricula = PAInput.readString("Matricula: ",false);
        int ano = PAInput.readInt("Ano de contrução: ");
        int maxLoad = PAInput.readInt("Maximo de carga: ");
        int maxPass = PAInput.readInt("Maximo de passageiros: ");
        PesadoPass car = new PesadoPass(matricula,ano,maxPass,maxLoad);
        if (!fleet.addCar(car)){
            System.out.println("Erro a adicionar carro!");
        }else {
            System.out.println("Carro adicionado com sucesso!");
        }
    }

    private void addLigeiro() {
        String matricula = PAInput.readString("Matricula: ",false);
        int ano = PAInput.readInt("Ano de contrução: ");
        int maxPass = PAInput.readInt("Maximo de carga: ");
        Ligeiro car = new Ligeiro(matricula,ano,maxPass);
        if (!fleet.addCar(car)){
            System.out.println("Erro a adicionar carro!");
        }else {
            System.out.println("Carro adicionado com sucesso!");
        }
    }

    void listAll() {

        System.out.println(fleet.toString());

    }
    void listMaxPass() {

        System.out.println(fleet.listPass());

    }
    void listMaxCarga() {


        System.out.println(fleet.listCarga());

    }

    void removeVehicle() {
        String matricula = PAInput.readString("Matricula do carro a remover: ",true);
        boolean deleted = fleet.removeVehicle(matricula);
        if (!deleted)
            System.out.println("Erro a remover carro!");
        else
            System.out.println("Carro removido com sucesso!");
    }

    public void start() {
        while (true) {
            switch (PAInput.chooseOption("Fleet " + fleet.getName() ,
                    "Add new car", "List all cars", "Remove book", "List cars with max passagers", "List cars with max cargo,",
                    "Quit")) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    listAll();
                    break;
                case 3:
                    removeVehicle();
                    break;
                case 4:
                    listMaxPass();
                    break;
                case 5:
                    listMaxCarga();
                    break;
                case 6:
                    return;
            }
        }
    }
}
