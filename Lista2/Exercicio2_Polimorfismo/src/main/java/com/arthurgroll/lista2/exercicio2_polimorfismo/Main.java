package com.arthurgroll.lista2.exercicio2_polimorfismo;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    
    public static void main(String[] args)
    {
        // Novamente, o exercício está feito, se quiser não precisa escrever nada na main.
        
        Gerente g = new Gerente();
        FieldManager fm = new FieldManager(g);
        
        System.out.println("Atributos em \"g\":\n" + fm.toString());
        
    }
}

class FieldManager
{
    private Object targetObj;
    private List<Field> fields;

    public FieldManager(Object objeto)
    {
        this.targetObj = objeto;
        this.fields = new ArrayList<>();
        
        for(Field f : objeto.getClass().getSuperclass().getDeclaredFields())
        {
            this.fields.add(f);
        }
    }
    
    @Override
    public String toString()
    {
        String retStr = "";
        
        for (Field field : this.fields)
        {
            try
            {
                field.setAccessible(true);
                retStr += String.format("Atributo %s = %s\n", field.getName(), field.get(this.targetObj));
            }
            catch (Exception e)
            {
                return null;
            }
        }
        
        return retStr;
    }
}