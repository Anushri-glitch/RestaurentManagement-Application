package com.shrishti.Restaurent_ManagementApplication.service;
import com.shrishti.Restaurent_ManagementApplication.model.Management;
import com.shrishti.Restaurent_ManagementApplication.model.RestaurentData.R_Employee;
import com.shrishti.Restaurent_ManagementApplication.model.Restaurent;
import com.shrishti.Restaurent_ManagementApplication.model.RestroSignInput;
import com.shrishti.Restaurent_ManagementApplication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurentService {

    @Autowired
    IRestaurentDao restaurentDao;

    @Autowired
    IRestroInputDao restroInputDao;

    @Autowired
    IEmployeeDao employeeDao;

    @Autowired
    IReportingDao reportingDao;

    @Autowired
    IManagementDao managementDao;


    public String createRestaurent(RestroSignInput restaurents) {
        Restaurent oldRestaurent = restaurentDao.findFirstByEmail(restaurents.getEmail());

        if(oldRestaurent == null){
            oldRestaurent.setRestaurentNewId(restaurents.getResId());
            oldRestaurent.setRestaurentUserName(restaurents.getRestaurentName());
            oldRestaurent.setRestaurentPublicName(restaurents.getRestaurentPublicName());
            oldRestaurent.setEmail(restaurents.getEmail());
            oldRestaurent.setRestaurentAdd(restaurents.getRestaurentAdd());
            oldRestaurent.setRestaurentSpeciality(restaurents.getRestaurentSpeciality());
            oldRestaurent.setRestaurentTotalStaff(restaurents.getRestaurentTotalStaff());
            oldRestaurent.setRestaurentPhone(restaurents.getRestaurentPhone());
            restaurentDao.save(oldRestaurent);
            restroInputDao.save(restaurents);
            return oldRestaurent.getRestaurentUserName() + "  Your New Account is Created!!..Thank You!";
        }
        return "Restaurent is Already Exist";

    }

    public String updateRestaurent(Restaurent restaurent, Integer resId) {
        Restaurent oldRestaurent = restaurentDao.findById(resId).get();
        if(restaurent != null) {
            oldRestaurent.setRestaurentPublicName(restaurent.getRestaurentPublicName());
            oldRestaurent.setRestaurentAdd(restaurent.getRestaurentAdd());
            oldRestaurent.setEmail(restaurent.getEmail());
            oldRestaurent.setRestaurentSpeciality(restaurent.getRestaurentSpeciality());
            oldRestaurent.setRestaurentTotalStaff(restaurent.getRestaurentTotalStaff());
            oldRestaurent.setRestaurentPhone(restaurent.getRestaurentPhone());
            restaurentDao.save(oldRestaurent);
            return oldRestaurent.getRestaurentPublicName() + " is Updated!!!";
        }
        return "Given Data is Null!!!";
    }


    public Restaurent findRestaurentById(Integer resId, String password) {

        RestroSignInput restroSignUpInput = restroInputDao.findFirstByPassword(password);
        if (restroSignUpInput != null)
            return restaurentDao.findById(resId).get();
        return null;
    }

    public String createEmployee(R_Employee employee) {

        if(!employeeDao.existsById(employee.getEmployeeId())){
            employeeDao.save(employee);
            return employee.getEmployeeName() + "  you are now saved as employee!!";
        }
        return "Employee Already Exists!!!";
    }

    public String createManagement(Management manage) {
        if(!managementDao.existsById(manage.getHrId())){
            managementDao.save(manage);
            return manage.getHrName() + "  , you are now saved as HR!!";
        }
        return "HR Already Exists!!!";
    }


    public Management findAdminByIdAndPassword(Integer hrId, String password) {
        return managementDao.findByIdAndPassword(hrId,password);
    }

    public List<Restaurent> getAllRestaurents() {
        return restaurentDao.findAll();
    }
}
