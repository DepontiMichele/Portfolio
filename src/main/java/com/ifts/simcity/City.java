/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifts.simcity;
import java.util.ArrayList;
import exceptions.*;

/**
 *
 * @author Michele Deponti
 */
public class City 
{
    protected ArrayList<BaseArea> areas;

    public City() 
    {
        this.areas = new ArrayList<>(); //Creiamo un ArrayList vuoto,
        //a cui aggiungere edifici
    }
    
    /**
     * Costruttore che definisce una capacità iniziale della proprietà
     * areas dell'istanza.
     * 
     * @param initialCapacity la dimensione iniziale della lista delle aree
     * @throws InvalidInitialCapacityException 
     */
    public City (int initialCapacity) throws InvalidInitialCapacityException
    {
        if (initialCapacity < 0)
        {
            throw new InvalidInitialCapacityException();
        }
        this.areas = new ArrayList<>(initialCapacity);
    }
    
    /**
     * Metodo che scansiona la proprietà areas alla ricerca di un'area
     * con codice == targetCode, e ne restituisce la posizione se presente.
     * Se in areas non fosse presente nessun edificio con codice == targetCode,
     * verrà restituito -1.
     * 
     * @param targetCode
     * @return 
     */
    public int indexOf(String targetCode)
    {
        int retvalue = -1;
        
        for (int i=0;i<this.areas.size();i++)
        {
            if (this.areas.get(i).getCode().equalsIgnoreCase(targetCode))
            {
                retvalue = i;
                break;
            }
        }
        return retvalue;
    }
    
    /**
     * Metodo che prova ad inserire candidate nella citta'. Se l'area non
     * fosse inseribile, sollevare una eccezione di tipo CodePresentException
     * se e' gia' presente un'altra area con lo stesso codice, oppure
     * AreaNotInsertableException in caso di collisione 
     * con almeno un altra area
     * 
     * @param candidate 
     */
    public void insertArea (BaseArea candidate) throws CodePresentException, AreaNotInsertableException
    {
       if(this.indexOf(candidate.code)> -1){
           throw new CodePresentException();
           
       }
       if(this.checkInsertion(candidate)>-1){
           throw new AreaNotInsertableException();
       }
       this.areas.add(candidate);
    }
    
    /**
     * Metodo che riceve in ingresso un'istanza di BaseArea candidata
     * ad entrare in areas.
     * 
     * @param candidate
     * @return -1 se candidate è inseribile nella città, >=0 contenente 
     * il primo edificio con cui confligge, altrimenti
     */
    public int checkInsertion(BaseArea candidate)
    {
        int retvalue = -1;
        
        for(int i=0; i<this.areas.size(); i++){
            if(!this.checkTarget(candidate, this.areas.get(i)))
            {
                retvalue = i;
                break;
            }
        }
        
        return retvalue;
    }
    
    public void removeAreaByCode(String Code) throws AreaNotFoundException
    {
        int position = this.indexOf(Code);
        if (position < 0 )
        {
            throw new AreaNotFoundException();
        }
        this.areas.remove(position);
    }
    
    public BaseArea clutter()
    {
        BaseArea retvalue = null;
        
        if (this.areas.size() >= 1)
        {
            retvalue = this.envelope(this.areas.get(0), this.areas.get(0));
        }
        
        for (int i=1;i<this.areas.size();i++)
        {
            retvalue = this.envelope(retvalue, this.areas.get(i));
        }
        
        return retvalue;
    }
    
    public BaseArea envelope(BaseArea area1, BaseArea area2)
    {
        int ix = area1.x < area2.x ? area1.x : area2.x;
        int iy = area1.y > area2.y ? area1.y : area2.y;
        int iw = area1.x + area1.w > area2.x + area2.w 
                ? area1.x + area1.w - ix
                : area2.x + area2.w - ix;
        int ih = area1.y - area1.h < area2.y - area2.h
                ? iy - area1.y - area1.h
                : iy - area2.y - area2.h;
        
        Building retvalue = null;
        
        try 
        {
            retvalue = new Building(ix,iy,iw,ih,"inviluppo");
        } 
        catch (Exception ex) 
        {
            //Qui non arriveremo mai (forse)
        }
        
        return retvalue;
    }
    
    /**
     * Metodo che calcola la superficie delle aree occupate della città
     * @return 
     */
    public long totalArea()
    {
        long retvalue = 0;
        
        //Sommare le aree di tutte gli elementi di BaseArea non 
        //contenuti in altre BaseArea
        for ( BaseArea el : this.areas)
        {
            if (!this.isWrapped(el))
            {
                retvalue += el.getSize();
            }
        }
        
        return retvalue;
    }
    
    public boolean isWrapped (BaseArea target)
    {
        boolean retvalue = false;
        //Ciclare su tutto areas
        for (int i =0;i<this.areas.size();i++)
        {
            //Verificare ad ogni iterazione se target è contenuto nella
            //BaseArea esaminata -> se si, interrompere il ciclo ed invertire
            //il valore di retvalue
            
            if (target != this.areas.get(i))
            {
                if (this.isWrapping(this.areas.get(i), target))
                {
                    retvalue = true;
                    break;
                }
            }
        }
        
        
        
        return retvalue;
    }
            
    
    /**
     * Metodo che verifica se l'area candidate e l'area target sono
     * compatibili.
     * 
     * @param candidate l'area candidata ad entrare nel piano
     * @param target l'area attualmente presente nel piano
     * @return true se le due aree sono compatibili, false altrimenti
     */
    protected boolean checkTarget(BaseArea candidate, BaseArea target)
    {
        return this.isInternal(candidate, target)
            || this.isExternal(candidate, target)
            || this.isWrapping(candidate, target);
    }
    
    protected boolean isInternal (BaseArea candidate, BaseArea target)
    {
        /*
        5a) ax >= vx 
        5b) ay <= vy
        5c) ax + aw <= vx + vw
        5d) ay - ah >= vy - vh
        */
        return candidate.x >= target.x
            && candidate.y <= target.y
            && candidate.x + candidate.w <= target.x + target.w
            && candidate.y - candidate.h >= target.y - target.h;
        
    }
    
    protected boolean isExternal (BaseArea candidate, BaseArea target)
    {
        /*
        1) ax + aw <= vx
        2) ay -ah >= vy
        3) ax >= vx + vw
        4) ay <= vy - vh
        */
        return  candidate.x + candidate.w <= target.x
             || candidate.y - candidate.h >= target.y
             || candidate.x >= target.x + target.w
             || candidate.y <= target.y - target.h;
    }
    
    protected boolean isWrapping (BaseArea candidate, BaseArea target)
    {
    /*  6a) ax <= vx 
        6b) ay >= vy
        6c) ax + aw >= vx + vw
        6d) ay - ah <= vy - vh */
        return     candidate.x <= target.x 
                && candidate.y >= target.y
                && candidate.x + candidate.w >= target.x + target.w
                && candidate.y - candidate.h <= target.y - target.h;
        
    }
    
    /**
     * metodo che calcola la differenza tra l'ingombro della città e 
     * l'area effettivamente occupata.
     * 
     * @return la differenza tra l'ingombro della città e 
     * l'area effettivamente occupata
     */
    public long freeAreaAmount()
    {
        return this.clutter().getSize() - this.totalArea();
    }
    
    /**
     * Metodo che calcola il numero dei residenti in città
     * 
     * @return il numero dei residenti della città
     */
    
    public long getResidentsAmount()
    {
        long retvalue = 0;
        
        for (int i=0; i<this.areas.size(); i++)
        {
            if (this.areas.get(i) instanceof Building)
            {
                retvalue += ((Building)this.areas.get(i)).getResidents();
            }
        }
        
        return retvalue;
    }
    
    /**
     * metodo che restituisce l'elenco delle aziende che hanno sede in città
     * 
     * @return l'elenco delle aziende che hanno sede in città
     */
    

}
