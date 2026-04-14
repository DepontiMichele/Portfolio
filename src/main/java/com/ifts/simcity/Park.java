/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifts.simcity;
import exceptions.*;

/**
 *
 * @author Michele Deponti
 */
public class Park extends BaseArea
{
    protected int trees;

    public int getTrees() 
    {
        return trees;
    }

    public void setTrees(int trees) throws InvalidTreesException 
    {   
        if (trees < 1)
        {
            throw new InvalidTreesException();
        }
        this.trees = trees;
    }

    public Park(int trees, int x, int y, int h, int w, String code) throws InvalidHeightException, InvalidWidthException, InvalidCodeException, InvalidTreesException {
        super(x, y, h, w, code);
       this.setTrees(trees);
    }
    
    
    
}
