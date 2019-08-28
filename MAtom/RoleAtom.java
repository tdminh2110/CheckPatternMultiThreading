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

public class RoleAtom extends Atom
{
    private String strDomainVariable;    
    private String strRangeVariable;    

    public RoleAtom(IRI iri)
    {
        super(iri);
        this.strDomainVariable = "";        
        this.strRangeVariable = "";
    }
	
    public RoleAtom(IRI iri, String strVariableDomain, String strVariableRange)
    {
        super(iri);
        this.strDomainVariable = strVariableDomain;        
        this.strRangeVariable = strVariableRange;
    }
    
    public void setDomainVariable(String strDomainVariable)
    {
        this.strDomainVariable = strDomainVariable;
    }
	
    public void setRangeVariable(String strRangeVariable)
    {
        this.strRangeVariable = strRangeVariable;
    }
	
    public String getDomainVariable()
    {
        return this.strDomainVariable;
    }
	
    public String getRangeVariable()
    {
        return this.strRangeVariable;
    }
}
