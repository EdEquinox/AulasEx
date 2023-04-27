package pt.isec.pa.aulas.four_in_a_row.model.data.memento;

public interface IOriginator {
    IMemento save();
    void restore(IMemento memento);
}
