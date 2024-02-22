package vla.kyr;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author Vlad
  @project   tdd-lab3
  @class  CompanyServiceImplTest
  @version  1.0.0 
  @since 2/22/2024 - 21.16
*/

class CompanyServiceImplTest {

    private final Company main = new Company(null,2);
    private final Company book = new Company(main,3);
    private final Company manager = new Company(main,4);
    private final Company developer = new Company(manager,8);
    private final Company design = new Company(manager,6);
    private final Company lawyer = new Company(null,1);

    private final List<Company> companies = List.of(main, book, manager, developer, design, lawyer);

    private final ICompanyService companyService = new CompanyServiceImpl();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenCompanyIsNullThenNull() {
        Company result = companyService.getTopLevelParent(null);
        Assertions.assertNull(result);
    }

    @Test
    void whenCompanyHasNoParentItIsOnTop() {
        Company result = companyService.getTopLevelParent(main);
        Assertions.assertEquals(main,result);
    }

    @Test
    void whenCompanyIsSingleItIsOnTop() {
        Company result = companyService.getTopLevelParent(lawyer);
        Assertions.assertEquals(lawyer,result);
    }

    @Test
    void whenCompanyHasOneStepToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(book);
        Assertions.assertEquals(main,result);
    }

    @Test
    void whenCompanyHasTwoStepsToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(developer);
        Assertions.assertEquals(main,result);
    }

    @Test void whenListOfCompanyIsNullThenZero(){
        long result = companyService.getEmployeeCountForCompanyAndChildren(main,null);
        Assertions.assertEquals(0,result);
    }

    @Test void whenCompanyIsNullThenZero(){
        long result = companyService.getEmployeeCountForCompanyAndChildren(null,companies);
        Assertions.assertEquals(0,result);
    }

    @Test void whenCompanyIsMainThenCount23(){
        long result = companyService.getEmployeeCountForCompanyAndChildren(main,companies);
        Assertions.assertEquals(23,result);
    }

    @Test void whenCompanyIsSingleThen1() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(lawyer,companies);
        Assertions.assertEquals(1,result);
    }

    @Test void whenCompanyIsMangerThen18() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(manager,companies);
        Assertions.assertEquals(18,result);
    }

    @Test void whenCompanyIsDeveloperThen8() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(developer,companies);
        Assertions.assertEquals(8,result);
    }

    @Test void whenListOfCompanyEmptyThenZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(developer,new ArrayList<>());
        Assertions.assertEquals(0,result);
    }








}