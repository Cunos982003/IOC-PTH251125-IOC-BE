package ra.edu.business;

import ra.edu.model.Student;

public interface IStudentService extends IBaseService{
    void searchByName();
    void classifyByGpa();
}
