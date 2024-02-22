package vla.kyr;
import java.util.List;

/*
  @author Vlad
  @project   tdd-lab3
  @class  ICompanyService
  @version  1.0.0 
  @since 2/22/2024 - 21.01
*/



public interface ICompanyService {
    Company getTopLevelParent(Company child);

    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
