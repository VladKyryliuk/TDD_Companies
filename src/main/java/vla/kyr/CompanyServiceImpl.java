package vla.kyr;/*
  @author Vlad
  @project   tdd-lab3
  @class  ICompanyServiceImpl
  @version  1.0.0 
  @since 2/22/2024 - 21.05
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
       if (child == null){
           return null;
       }
       if (child.getParent() == null) {
           return child;
       }
       else {
           while (child.getParent() != null) {
               child = child.getParent();
           }
           return child;
       }
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null || companies == null || companies.isEmpty()) {
            return 0;
        }

        long result = company.getEmployeeCount();

        for (Company child : companies) {
            if (child.getParent() == company) {
                result += getEmployeeCountForCompanyAndChildren(child, companies);
            }
        }

        return result;
    }
}
