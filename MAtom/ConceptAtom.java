/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAtom;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author tdminh
 */

public class ConceptAtom extends Atom
{
    private String strVariable;
    
    public ConceptAtom(IRI iri)
    {
        super(iri);
        this.strVariable = "";       
    }
	
    public ConceptAtom(IRI iri, String strVariable)
    {
        super(iri);
        this.strVariable = strVariable;
    }
    
    public void setVariable(String strVariable)
    {
        this.strVariable = strVariable;
    }
	
    public String getVariable()
    {
        return this.strVariable;
    }
}
