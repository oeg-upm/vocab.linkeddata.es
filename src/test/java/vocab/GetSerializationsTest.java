/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

import java.util.ArrayList;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dgarijo
 */
public class GetSerializationsTest {
    
    public GetSerializationsTest() {
    }
    
    @Test
    public void testGetSerializations(){
        //this vocabulary supports rdf and text/html
        ArrayList<String> s = VocabUtils.getSerializationsOfVocab("http://purl.org/net/p-plan");
        if(!s.contains("application/rdf+xml") || !s.contains("text/html")){
            fail();
        }
    }

    
    
}
