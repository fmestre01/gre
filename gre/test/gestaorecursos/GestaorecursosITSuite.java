/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.model.ModelITSuite.class, gestaorecursos.resources.ResourcesITSuite.class, gestaorecursos.relatorios.RelatoriosITSuite.class, gestaorecursos.testeIT.class, gestaorecursos.views.ViewsITSuite.class, gestaorecursos.MainIT.class, gestaorecursos.Controller.ControllerITSuite.class})
public class GestaorecursosITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
