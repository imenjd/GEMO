package sample.dao;
import sample.entities.Visit;
public interface VisitDao {
  void insert(Visit visit);
  int ExtractIdVisit(Visit visit);
  void insert2(Visit visit);
  void insert3(Visit visit);
  void insert4(Visit visit);
  int searchLast();
  
}
