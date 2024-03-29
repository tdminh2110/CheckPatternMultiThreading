
import MCommon.Global;
import MOutput.OutputInformation;
import MPattern.CheckPattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tdminh
 */
public class MainClass 
{
    public static void main(String args[])
    {        
        //final String STR_PART_OF_FILE_NAME = "/home/tdminh/Datas/GA_03_11_2017/GiniIndex/NTMerged_20/NTMerged_20_";
        final String STR_PART_OF_FILE_NAME = "/home/tdminh/Datas/GA_11_09_2018/Biopax_20/Biopax_20_";
        
        for (int i = 1; i <= 1; i++)
        {   
            System.out.println();
            System.out.println("=======================================================");
            System.out.println("BEGIN THE SAMPLE " + i);
            
            Global.INPUT_PATTERNS_IN_FILE = STR_PART_OF_FILE_NAME + String.valueOf(i) + ".txt";

            Global.THREAD_SLEEP = 20000;        
            OutputInformation output = new OutputInformation(STR_PART_OF_FILE_NAME + String.valueOf(i) + "_consistent.txt");
            CheckPattern checkPattern = new CheckPattern();
            checkPattern.checkForListPatterns();        
            output.closeFile();
            
            System.out.println("END THE SAMPLE " + i);
            System.out.println("=======================================================");
            System.out.println();
        }
        
        /*OutputInformation output = new OutputInformation(Global.OUTPUT_PATTERNS_IN_FILE);
        CheckPattern checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();*/
        
        
        /*Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_1.txt";
        
        Global.THREAD_SLEEP = 10000;                
        OutputInformation output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_1_consistent_10s.txt");
        CheckPattern checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;        
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_1_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_1_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_2.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_2_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_2_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_2_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_3.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_3_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_3_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_3_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_4.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_4_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_4_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_4_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_5.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_5_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_5_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_5_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_6.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_6_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_6_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_6_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_7.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_7_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_7_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_7_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_8.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_8_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_8_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_8_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_9.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_9_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_9_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();        
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_9_consistent_30s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();*/
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        /*Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/NTMerged_20_10.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_10_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_10_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        OutputInformation output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_10_consistent_30s.txt");
        CheckPattern checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.INPUT_PATTERNS_IN_FILE = "/home/tdminh/Datas/GA_24_01_2017/NTMerged_20.txt";
        
        Global.THREAD_SLEEP = 10000; 
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_10_consistent_10s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 20000;       
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_04_07_2016/NTMerged_20/Support/NTMerged_20_10_consistent_20s.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();
        
        Global.THREAD_SLEEP = 30000;
        output = null; checkPattern = null;
        output = new OutputInformation("/home/tdminh/Datas/GA_24_01_2017/NTMerged_20_consistent.txt");
        checkPattern = new CheckPattern();
        checkPattern.checkForListPatterns();        
        output.closeFile();*/
    }
}
