package pt.isec.pa.aulas.four_in_a_row.model.data.memento;

public interface IMemento {
    default Object getSnapshot(){
        return null;
    }
}
