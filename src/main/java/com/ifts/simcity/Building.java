package com.ifts.simcity;


import com.ifts.simcity.BaseArea;
import com.ifts.simcity.interfaces.ICommercial;
import com.ifts.simcity.interfaces.IResidential;
import exceptions.*;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michele Deponti
 */
public class Building extends BaseArea
        implements IResidential,ICommercial
{
    protected ArrayList<String> companies;  
    protected int residents;

    public Building(int x, int y, int h, int w, String code) throws InvalidHeightException, InvalidWidthException, InvalidCodeException 
    {
        super(x, y, h, w, code);
        this.residents = 0;
        this.companies = new ArrayList<>();
    }
    //Metodo che prova ad aggiungere newCompany 
    //alla lista delle aziende del palazzo
    public void addCompany(String candidate) throws CompanyPresentException, InvalidCompanyNameException
    {
        try
        {
            
            if (this.indexOf(candidate) >= 0)
            {
                throw new CompanyPresentException();
            }

            this.companies.add(candidate);
        }
        catch (NullPointerException | InvalidCompanyNameException ex)
        {
            throw new InvalidCompanyNameException();
        }
    }
    
    //Metodo che prova a rimuovere l'azienda target dall'ArrayList companies
    public void removeCompany(String target) throws CompanyNotFoundException, InvalidCompanyNameException
    {
        try
        {
            
            int position = this.indexOf(target);

            if (position < 0)
            {
                throw new CompanyNotFoundException();
            }

            this.companies.remove(position);
        }
        catch (NullPointerException | InvalidCompanyNameException ex)
        {
            throw new InvalidCompanyNameException();
        }
        
            
    }

    //Metodo che restituisce la posizione di companyName all'interno di 
    //companies se presente, -1 altrimenti
    public int indexOf(String companyName) throws InvalidCompanyNameException
    {
        if (companyName.length() < Configuration.COMPANY_NAME_LENGTH)
        {
            throw new InvalidCompanyNameException();
        }
        
        int retvalue = -1;
        
        for (int i=0;i<this.companies.size();i++)
        {
            if (this.companies.get(i).equalsIgnoreCase(companyName))
            {
                retvalue = i;
                break;
            }
        }
        
        return retvalue;
    }

    public int getResidents() {
        return residents;
    }
    
    public void toggleResidents(int delta) throws InvalidResidentsException
    {
        if ( this.residents + delta < 0)
        {
            throw new InvalidResidentsException();            
        }
        this.residents += delta;     
    }
          
    public float getPollution()
    {    
        return this.residents * Configuration.pollutionMultiplier;
    }

    public String[] getCompanies() 
    {
        return (String[])this.companies.toArray();
    }
    
    
}
