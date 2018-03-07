/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.Controller.Relatorios;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.Controller.Relatorios.RelPrestacaoContasControllerIT.class, gestaorecursos.Controller.Relatorios.ImprimirBensCEControllerIT.class, gestaorecursos.Controller.Relatorios.ImprimirPagCEControllerIT.class, gestaorecursos.Controller.Relatorios.RelBensControllerIT.class, gestaorecursos.Controller.Relatorios.RelConciliacaoControllerIT.class, gestaorecursos.Controller.Relatorios.ImprimirConcCEControllerIT.class, gestaorecursos.Controller.Relatorios.RelTermoDoacaoControllerIT.class})
public class RelatoriosITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
