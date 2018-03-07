/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.resources;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.resources.css.CssITSuite.class, gestaorecursos.resources.img.ImgITSuite.class})
public class ResourcesITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
