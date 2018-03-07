/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.Controller.SR;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.Controller.SR.AdicoesSRControllerIT.class, gestaorecursos.Controller.SR.RecebimentosSRControllerIT.class, gestaorecursos.Controller.SR.SaldosSRControllerIT.class, gestaorecursos.Controller.SR.ConciliacaoSRControllerIT.class, gestaorecursos.Controller.SR.PagamentosSRControllerIT.class, gestaorecursos.Controller.SR.DeducoesSRControllerIT.class})
public class SRITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
