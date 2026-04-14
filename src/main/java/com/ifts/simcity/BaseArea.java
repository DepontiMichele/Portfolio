package com.ifts.simcity;
import exceptions.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michele Deponti
 */
public abstract class BaseArea 
{
    protected int x, y, h, w;
    protected String code;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public String getCode() {
        return code;
    }

    private void setH(int h) throws InvalidHeightException 
    {
        if (h < 1)
        {
            throw new InvalidHeightException();
        }
        this.h = h;
    }

    private void setW(int w) throws InvalidWidthException 
    {
        if (w < 1)
        {
            throw new InvalidWidthException();
        }
        this.w = w;
    }

    private void setCode(String code) throws InvalidCodeException 
    {
        try
        {
            if(code.length()<5)
            {
                throw new InvalidCodeException();
            }
            
        }
        catch (InvalidCodeException | NullPointerException ex)
        {
            throw new InvalidCodeException();
        }
                
        this.code = code;
    }

    public BaseArea(int x, int y, int h, int w, String code) throws InvalidHeightException, InvalidWidthException, InvalidCodeException {
        this.x = x;
        this.y = y;
        this.setH(h);
        this.setW(w);
        this.setCode(code);
    }
    
    public long getSize ()
    {
        return this.w * this.h;
    }
}
