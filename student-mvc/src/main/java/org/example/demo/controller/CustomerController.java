package org.example.demo.controller;

import org.example.demo.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/showForm")
    public String showFormForCustomer(Model theModel)
    {
        theModel.addAttribute("customer",new Customer());
            return "customer-form";
    }
    @RequestMapping("/processForm")
    public String processFormForCustomer(@Validated @Valid @ModelAttribute("customer") Customer customer, BindingResult theResult)
    {
        if (theResult.hasErrors())
        {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }

    }
}
