package MKnowledge;

import MAtom.ConceptAtom;
import MAtom.RoleAtom;
import MCommon.Global;
import MPattern.Pattern;
import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.vocab.PrefixOWLOntologyFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tdminh
 */
public class KnowledgeBase 
{
    private OWLOntologyManager ontologyManager;
    private OWLDataFactory dataFactory;	
    private OWLOntology ontology;
    private IRI iri;
    private PelletReasoner reasonerPellet;
    private Reasoner reasonerHermit;
    
    private PrefixOWLOntologyFormat prefix;
    
    public KnowledgeBase(IRI iri)
    {
        try 
        {
            this.iri = iri;
            this.ontologyManager = OWLManager.createOWLOntologyManager();
            this.dataFactory = this.ontologyManager.getOWLDataFactory();
            this.ontology = this.ontologyManager.loadOntologyFromOntologyDocument(iri);
            this.reasonerPellet = PelletReasonerFactory.getInstance().createReasoner(this.ontology);
            this.reasonerHermit = new Reasoner(this.ontology);
            
            this.prefix = (PrefixOWLOntologyFormat) this.ontologyManager.getOntologyFormat(this.ontology); 
            this.prefix.setDefaultPrefix(Global.BASE_URL); 
        } 
        catch (OWLOntologyCreationException e) 
        {	
            e.printStackTrace();
	}
    }
    
    public boolean isConsistent()
    {
        try
        {
            if (Global.TYPE_OF_REASONER.equals("Pellet"))   
                return this.reasonerPellet.isConsistent();                    
            else if (Global.TYPE_OF_REASONER.equals("Hermit"))
                return this.reasonerHermit.isConsistent();
            else
                return false;
        }
        catch(org.mindswap.pellet.exceptions.InternalReasonerException e)
        {
            e.printStackTrace();
            return false;
        }
        catch(org.semanticweb.owlapi.reasoner.TimeOutException e)
        {
            e.printStackTrace();
            return false;
        }
        catch(org.mindswap.pellet.exceptions.TimeoutException e)
        {
            e.printStackTrace();
            return false;
        }        
        catch(java.lang.OutOfMemoryError e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public OWLOntologyManager getOntologyManager()
    {
        return this.ontologyManager;
    }
    
    public OWLDataFactory getDataFactory()
    {
        return this.dataFactory;
    }
    
    public OWLOntology getOntology()
    {
        return this.ontology;
    }
    
    public IRI getIRI()
    {
        return this.iri;
    }
    
    public PelletReasoner getPelletReasoner()
    {
    	return this.reasonerPellet;
    }
    
    public Reasoner getHermitReasoner()
    {
        return this.reasonerHermit;
    }
    
    public PrefixOWLOntologyFormat getPrefix()
    {
        return this.prefix;
    }
    
    public boolean addPatternHorn(Pattern pattern)
    {
        try 
        {            
            SWRLAtom head = null;
            Set<SWRLAtom> body = new LinkedHashSet<SWRLAtom>();
            
            for(int i = 0; i < pattern.size(); i++)
            {
                if (i == 0)
                {
                    if (pattern.get(0) instanceof ConceptAtom)
                    {
                        OWLClass conceptAtom = this.dataFactory.getOWLClass(((ConceptAtom) pattern.get(i)).getIRI());
                        SWRLVariable var = this.dataFactory.getSWRLVariable(IRI.create(((ConceptAtom) pattern.get(i)).getVariable()));
                        head = this.dataFactory.getSWRLClassAtom(conceptAtom, var);
                    }
                    else if (pattern.get(0) instanceof RoleAtom)
                    {
                        OWLObjectProperty roleAtom = this.dataFactory.getOWLObjectProperty(((RoleAtom) pattern.get(i)).getIRI());
                        SWRLVariable var1 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getDomainVariable()));
                        SWRLVariable var2 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getRangeVariable()));
                        head = this.dataFactory.getSWRLObjectPropertyAtom(roleAtom, var1, var2);
                    }
                }
                else
                {
                    if (pattern.get(i) instanceof ConceptAtom)
                    {
                        OWLClass conceptAtom = this.dataFactory.getOWLClass(((ConceptAtom) pattern.get(i)).getIRI());
                        SWRLVariable var = this.dataFactory.getSWRLVariable(IRI.create(((ConceptAtom) pattern.get(i)).getVariable()));
                        body.add(this.dataFactory.getSWRLClassAtom(conceptAtom, var));
                    }
                    else if (pattern.get(i) instanceof RoleAtom)
                    {
                        OWLObjectProperty roleAtom = this.dataFactory.getOWLObjectProperty(((RoleAtom) pattern.get(i)).getIRI());
                        SWRLVariable var1 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getDomainVariable()));
                        SWRLVariable var2 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getRangeVariable()));
                        body.add(this.dataFactory.getSWRLObjectPropertyAtom(roleAtom, var1, var2));
                    
                    }
                }                
            }
            
            SWRLRule swrlRule = this.dataFactory.getSWRLRule(body, Collections.singleton(head));		
            this.ontologyManager.applyChange(new AddAxiom(this.ontology, swrlRule));

            if (Global.TYPE_OF_REASONER.equals("Pellet")) 
            {   
                this.reasonerPellet = null;
                
                OWLReasonerConfiguration config = new SimpleConfiguration();            
                this.reasonerPellet = PelletReasonerFactory.getInstance().createReasoner(this.ontology, config);
                //this.reasonerPellet.getKB().setTimeout(5000);
                
            }
            else if (Global.TYPE_OF_REASONER.equals("Hermit"))
            {
                this.reasonerHermit = null;
                this.reasonerHermit = new Reasoner(this.ontology);
            }
            else
                return false;            
            
            if (!this.isConsistent())
                return false;
            else            
                return true;
        }        
        catch(org.mindswap.pellet.exceptions.InternalReasonerException e)
        {
            e.printStackTrace();
            return false;
        }
        catch(org.semanticweb.owlapi.reasoner.TimeOutException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    /*public boolean addPatternHorn(Pattern pattern)
    {
        try 
        {            
            SWRLAtom head = null;
            Set<SWRLAtom> body = new LinkedHashSet<SWRLAtom>();
            
            for(int i = 0; i < pattern.size(); i++)
            {
                if (i == 0)
                {
                    if (pattern.get(0) instanceof ConceptAtom)
                    {
                        OWLClass conceptAtom = this.dataFactory.getOWLClass(((ConceptAtom) pattern.get(i)).getIRI());
                        SWRLVariable var = this.dataFactory.getSWRLVariable(IRI.create(((ConceptAtom) pattern.get(i)).getVariable()));
                        head = this.dataFactory.getSWRLClassAtom(conceptAtom, var);
                    }
                    else if (pattern.get(0) instanceof RoleAtom)
                    {
                        OWLObjectProperty roleAtom = this.dataFactory.getOWLObjectProperty(((RoleAtom) pattern.get(i)).getIRI());
                        SWRLVariable var1 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getDomainVariable()));
                        SWRLVariable var2 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getRangeVariable()));
                        head = this.dataFactory.getSWRLObjectPropertyAtom(roleAtom, var1, var2);
                    }
                }
                else
                {
                    if (pattern.get(i) instanceof ConceptAtom)
                    {
                        OWLClass conceptAtom = this.dataFactory.getOWLClass(((ConceptAtom) pattern.get(i)).getIRI());
                        SWRLVariable var = this.dataFactory.getSWRLVariable(IRI.create(((ConceptAtom) pattern.get(i)).getVariable()));
                        body.add(this.dataFactory.getSWRLClassAtom(conceptAtom, var));
                    }
                    else if (pattern.get(i) instanceof RoleAtom)
                    {
                        OWLObjectProperty roleAtom = this.dataFactory.getOWLObjectProperty(((RoleAtom) pattern.get(i)).getIRI());
                        SWRLVariable var1 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getDomainVariable()));
                        SWRLVariable var2 = this.dataFactory.getSWRLVariable(IRI.create(((RoleAtom) pattern.get(i)).getRangeVariable()));
                        body.add(this.dataFactory.getSWRLObjectPropertyAtom(roleAtom, var1, var2));
                    
                    }
                }                
            }
            
            SWRLRule swrlRule = this.dataFactory.getSWRLRule(body, Collections.singleton(head));		
            this.ontologyManager.applyChange(new AddAxiom(this.ontology, swrlRule));

            if (Global.TYPE_OF_REASONER.equals("Pellet")) 
            {   
                this.reasonerPellet = null;
                
                OWLReasonerConfiguration config = new SimpleConfiguration();            
                this.reasonerPellet = PelletReasonerFactory.getInstance().createReasoner(this.ontology, config);
                //this.reasonerPellet.getKB().setTimeout(5000);
                
            }
            else if (Global.TYPE_OF_REASONER.equals("Hermit"))
            {
                this.reasonerHermit = null;
                this.reasonerHermit = new Reasoner(this.ontology);
            }
            else
                return false;            
            
            if (!this.isConsistent())
                return false;
            else            
                return true;
        }        
        catch(org.mindswap.pellet.exceptions.InternalReasonerException e)
        {
            e.printStackTrace();
            return false;
        }
        catch(org.semanticweb.owlapi.reasoner.TimeOutException e)
        {
            e.printStackTrace();
            return false;
        }
    }*/
}
