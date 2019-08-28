/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MPattern;

import MAtom.ConceptAtom;
import MAtom.RoleAtom;
import MCommon.Global;
import MKnowledge.KnowledgeBase;
import MOutput.OutputInformation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author tdminh
 */
public class CheckPattern 
{
    private KnowledgeBase kb;
    ArrayList<Pattern> listPatterns;
    
    public CheckPattern()
    {
        try
        {
            this.kb = new KnowledgeBase(Global.IRI_INPUT_STRATIFIED);
            
            FileReader inputFile = new FileReader(Global.INPUT_PATTERNS_IN_FILE);
            BufferedReader brInputFile = new BufferedReader(inputFile);
            
            listPatterns = new ArrayList<Pattern>();
            
            String line = "";            
            while ((line = brInputFile.readLine()) != null)
            {
                String strPattern = line.substring(line.indexOf(".") + 1, line.lastIndexOf("&") + 1).trim();
                //String strPattern = line.substring(0, line.lastIndexOf("&") + 1).trim();
                double dblMetric = Double.valueOf(line.substring(line.lastIndexOf("&") + 1).trim());
                
                Pattern pattern = new Pattern(this.kb, strPattern);
                pattern.setMetric(dblMetric);
                listPatterns.add(pattern);
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
    
    public void checkForListPatterns()
    {     
        Global.listCheckedPatterns = new ArrayList<Pattern>();
        
        int count = 0;
        int countGroup = 0;
        
        for(int i=0; i<this.listPatterns.size(); i++)
        {
            if (Global.NUMBER_OF_THREAD < Global.MAX_THREAD)
            {                
                Global.arrThreadCheckPattern[Global.NUMBER_OF_THREAD] = null;
                Global.arrThreadCheckPattern[Global.NUMBER_OF_THREAD] = new ThreadCheckPattern(this.listPatterns.get(i));
                Global.arrThreadCheckPattern[Global.NUMBER_OF_THREAD].start();
                Global.NUMBER_OF_THREAD++;
                count++;
            }
                
            if (Global.NUMBER_OF_THREAD == Global.MAX_THREAD)
            {
                countGroup++;
                System.out.println("Group: " + countGroup);
                
                Global.threadCheckThread = null;
                Global.threadCheckThread = new ThreadCheckThread();
                Global.threadCheckThread.start();
                
                try
                {
                    Global.iNumberOfThreadCompleted = 0;
                    Global.iNumberOfThreadRunning = Global.NUMBER_OF_THREAD;
                    
                    for(int j = 0; j < Global.NUMBER_OF_THREAD; j++)                     
                        Global.arrThreadCheckPattern[j].join();
                    
                    Global.threadCheckThread.join();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                catch(java.lang.ArrayIndexOutOfBoundsException e)
                {
                    e.printStackTrace();
                }

                Global.NUMBER_OF_THREAD = 0;
                count = 0;
            }
            
            /*if (checkForOnePattern(listPatterns.get(i)))
            {
                countPatterns++;
                System.out.println("Consistent: " + countPatterns);
                listCheckedPatterns.add(listPatterns.get(i));
            }
            else
            {
                countErrorPatterns++;
                System.out.println("Inconsistent or Error : " + countErrorPatterns);
            }*/
        }
        
        if (count > 0)
        {
            countGroup++;            
            System.out.println("Group: " + countGroup);
            
            Global.threadCheckThread = null;
            Global.threadCheckThread = new ThreadCheckThread();
            Global.threadCheckThread.start();
            
            try
            {
                Global.iNumberOfThreadCompleted = 0;
                Global.iNumberOfThreadRunning = count;
                
                for(int j = 0; j < count; j++)
                    Global.arrThreadCheckPattern[j].join();                    
                
                Global.threadCheckThread.join();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            catch(java.lang.ArrayIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }

            Global.NUMBER_OF_THREAD = 0;
            count = 0;
        }
        
        for(int i=0; i<Global.listCheckedPatterns.size(); i++)
        {
            OutputInformation.showPatternWithNumber(Global.listCheckedPatterns.get(i), i + 1, false);
            System.out.println(i+1);
        }
        
        //OutputInformation.showTextln("Number of consistent: " + String.valueOf(Global.iNumberOfConsistent), false);
        //OutputInformation.showTextln("Number of inconsistent: " + String.valueOf(Global.iNumberOfInconsistent), false);
        //OutputInformation.showTextln("Number of error: " + String.valueOf(Global.iNumberOfError), false);
    }
    
    
}
