package Control;
import ADT.DoublyLinkedList;

public interface ReportCriteriaInterface<T> {
    public String generateReport(DoublyLinkedList<T> list);
}