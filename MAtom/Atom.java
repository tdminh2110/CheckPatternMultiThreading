/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAtom;

import MCommon.Global;
import org.semanticweb.owlapi.model.IRI;

/**
 *
 * @author tdminh
 */

public class Atom 
{	
    private IRI iri;

    public Atom(IRI iri)
    {
        this.iri = iri;
    }

    public IRI getIRI()
    {
        return this.iri;
    }
    
    public String getName()
    {
        return Global.cutNameOfIRI(iri.toString());        
    }
    
    @Override
    public int hashCode() 
    {
        return this.getName().hashCode();
    }

    public boolean equals(Object obj)
    {
        return ((obj instanceof Atom) && (((Atom) obj).getIRI().equals(this.iri)) );
    }
}
