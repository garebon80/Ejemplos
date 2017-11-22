package com.inatlas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inatlas.models.Address;
import com.inatlas.models.AddressDao;

@Controller
@RequestMapping(value="/address")
public class AddressController {

  @Autowired
  private AddressDao addresDao;
  
  @RequestMapping(value="/save")
  @ResponseBody
  public String create(String name) {
    try {
      Address address = new Address(name);
      addresDao.save(address);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Address succesfully saved!";
  }  
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Address address = new Address(id);
      addresDao.delete(address);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Address succesfully deleted!";
  }  


 

} // class UserController
