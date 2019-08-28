/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MOutput;

import MAtom.Atom;
import MAtom.ConceptAtom;
import MAtom.RoleAtom;
import MPattern.Pattern;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author tdminh
 */
public class OutputInformation 
{
    public static File outputFile = null;
    public static PrintStream print_file = null;
    
    public OutputInformation()
    {
    }
    
    public OutputInformation(String strOutputFileName)
    {
        try
        {
            OutputInformation.outputFile = new File(strOutputFileName);
            OutputInformation.print_file = new PrintStream(OutputInformation.outputFile);
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
    
    public static void showPattern(Pattern pattern, boolean type)
    {
        PrintStream output = OutputInformation.outputType(type);
        
        for(int j = 0; j < pattern.size(); j++)
        {
            Atom atom = (Atom) pattern.get(j);

            if (j == 0)
            {
                if (atom instanceof ConceptAtom)                
                    output.print(atom.getName() + "(" +  ((ConceptAtom) atom).getVariable() + ") <= ");
                else if (atom instanceof RoleAtom)                
                    output.print(atom.getName() + "(" + ((RoleAtom) atom).getDomainVariable() + ", " + ((RoleAtom) atom).getRangeVariable() + ") <= ");                
            }
            else
            {
                if (atom instanceof ConceptAtom)                
                    output.print(atom.getName() + "(" +  ((ConceptAtom) atom).getVariable() + ") & ");
                else if (atom instanceof RoleAtom)                
                    output.print(atom.getName() + "(" + ((RoleAtom) atom).getDomainVariable() + ", " + ((RoleAtom) atom).getRangeVariable() + ") & ");                
            }
        }
        output.print("\t");            
        output.println(pattern.getMetric());
    }
    
    //Ban goc cua GA
    public static void showPatternWithNumber(Pattern pattern, int number, boolean type)
    {
        PrintStream output = OutputInformation.outputType(type);
        
        output.print(String.valueOf(number) + ". ");
        
        for(int j = 0; j < pattern.size(); j++)
        {
            Atom atom = (Atom) pattern.get(j);

            if (j == 0)
            {
                if (atom instanceof ConceptAtom)                
                    output.print(atom.getName() + "(" +  ((ConceptAtom) atom).getVariable() + ") <= ");
                else if (atom instanceof RoleAtom)                
                    output.print(atom.getName() + "(" + ((RoleAtom) atom).getDomainVariable() + ", " + ((RoleAtom) atom).getRangeVariable() + ") <= ");                
            }
            else
            {
                if (atom instanceof ConceptAtom)                
                    output.print(atom.getName() + "(" +  ((ConceptAtom) atom).getVariable() + ") & ");
                else if (atom instanceof RoleAtom)                
                    output.print(atom.getName() + "(" + ((RoleAtom) atom).getDomainVariable() + ", " + ((RoleAtom) atom).getRangeVariable() + ") & ");                
            }
        }
        output.print("\t");            
        output.println(pattern.getMetric());
    }
    
    public static void showText(String strText, boolean type)
    {
        OutputInformation.outputType(type).print(strText);
    }

    public static void showTextln(String strText, boolean type)
    {
        OutputInformation.outputType(type).println(strText);
    }
    
    public static PrintStream outputType(boolean type)
    {
        if (type)
            return System.out;
        else
            return OutputInformation.print_file;
    }
	
    public void closeFile()
    {
        if (OutputInformation.print_file != null)        
            OutputInformation.print_file.close();
    }
    
}
