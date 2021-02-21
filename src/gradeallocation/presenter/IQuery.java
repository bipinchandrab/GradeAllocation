package gradeallocation.presenter;

//interface created for query execution

import gradeallocation.view.StudentDetails;

public interface IQuery {

    public void query();
    public void createDetails(StudentDetails studentDetails);
}
