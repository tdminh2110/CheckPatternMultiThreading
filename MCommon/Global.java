/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCommon;

import MPattern.Pattern;
import MPattern.ThreadCheckPattern;
import MPattern.ThreadCheckThread;
import java.util.ArrayList;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author tdminh
 */
public class Global 
{
    //public static final String BASE_URL = "http://semanticbible.org/ns/2005/NTNames#";
    //public static final String BASE_URL = "http://www.owl-ontologies.com/unnamed.owl#";
    public static final String BASE_URL = "http://www.biopax.org/examples/glycolysis#";
    //public static final String BASE_URL = "http://www.di.uniba.it/~cdamato/ontologies/Dinastie#";
    
    //public static final String FILE_NAME_STRATIFIED = "file:/home/tdminh/Datas/SemanticWeb/owls/NTMerged_20.owl";
    //public static final String FILE_NAME_STRATIFIED = "file:/home/tdminh/Datas/SemanticWeb/owls/Financial_20.owl";
    public static final String FILE_NAME_STRATIFIED = "file:/home/tdminh/Datas/SemanticWeb/owls/Biopax_20.owl";
    //public static final String FILE_NAME_STRATIFIED = "file:/home/tdminh/Datas/SemanticWeb/DinastieConPiuFamiglieEnglishVersion.owl";
    
    //public static final String FILE_NAME_FULL = "file:/home/tdminh/Datas/SemanticWeb/owls/NTMerged_Full.owl";
    //public static final String FILE_NAME_FULL = "file:/home/tdminh/Datas/SemanticWeb/owls/Financial_Full.owl";
    public static final String FILE_NAME_FULL = "file:/home/tdminh/Datas/SemanticWeb/owls/Biopax_Full.owl";
    //public static final String FILE_NAME_FULL = "file:/home/tdminh/workspace/JenaTutorial/minh_owls/DinastieConPiuFamiglieEnglishVersion.owl";
    
    public static final IRI IRI_INPUT_STRATIFIED = IRI.create(FILE_NAME_STRATIFIED);
    public static final IRI IRI_INPUT_FULL = IRI.create(FILE_NAME_FULL);
    
    public static String INPUT_PATTERNS_IN_FILE = "";//home/tdminh/Datas/GA_04_07_2016/Financial_20/Financial_20_9.txt";    
    public static String OUTPUT_PATTERNS_IN_FILE = "";//home/tdminh/Datas/GA_04_07_2016/Financial_20/Support/Financial_20_9_consistent_";    
    
    //public static final String TYPE_OF_REASONER = "Hermit";
    public static final String TYPE_OF_REASONER = "Pellet";
    
    public static final int MAX_THREAD = 10;
    public static int NUMBER_OF_THREAD = 0;
    
    public static int THREAD_SLEEP = 0;
    
    public static int iNumberOfConsistent = 0;
    public static int iNumberOfInconsistent = 0;
    public static int iNumberOfError = 0;
    
    public static ArrayList<Pattern> listCheckedPatterns = null;
    public static ThreadCheckPattern[] arrThreadCheckPattern = new ThreadCheckPattern[Global.MAX_THREAD];
    
    public static ThreadCheckThread threadCheckThread = null;
    
    public static int iNumberOfThreadCompleted = 0;
    public static int iNumberOfThreadRunning = 0;
        
    public static String cutNameOfIRI(String str)
    {
        String[] parts = str.split("#");		
        return parts[1]; 
    }
}
