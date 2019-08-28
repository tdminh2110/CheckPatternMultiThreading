/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MPattern;

import MCommon.Global;
import MKnowledge.KnowledgeBase;

/**
 *
 * @author tdminh
 */
public class ThreadCheckPattern extends Thread
{
    private Pattern pattern;
    
    public ThreadCheckPattern(Pattern pattern)
    {
        this.pattern = pattern;
    }
    
    public void run()
    {
        if (checkForOnePattern(this.pattern))
        {
            System.out.println("Consistent");
            Global.listCheckedPatterns.add(this.pattern);
            Global.iNumberOfConsistent++;
        }
        else
        {
            System.out.println("Inconsistent");
            Global.iNumberOfInconsistent++;
        }
        
        Global.iNumberOfThreadCompleted++;
        
        if (Global.iNumberOfThreadCompleted == Global.iNumberOfThreadRunning)
        {
            if (Global.threadCheckThread.isAlive())            
                Global.threadCheckThread.stop();
        }
    }
    
    public boolean checkForOnePattern(Pattern pattern)
    {       
        try 
    	{   
            KnowledgeBase kb_stratified = new KnowledgeBase(Global.IRI_INPUT_STRATIFIED);
            KnowledgeBase kb_full = new KnowledgeBase(Global.IRI_INPUT_FULL);
            
            if (kb_stratified.addPatternHorn(pattern))
            {
                if (kb_full.addPatternHorn(pattern))
                    return true;
                else
                    return false;
            }
            else
                return false;
            
        }
        catch (NullPointerException | java.lang.OutOfMemoryError | org.semanticweb.owlapi.reasoner.InconsistentOntologyException r)
        {
            r.printStackTrace();
            return false;
        }
    }
}
