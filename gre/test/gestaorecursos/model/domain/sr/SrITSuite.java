/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.model.domain.sr;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.model.domain.sr.PagamentosSRIT.class, gestaorecursos.model.domain.sr.AdicoesSRIT.class, gestaorecursos.model.domain.sr.SaldosSRIT.class, gestaorecursos.model.domain.sr.ConciliacaoSRIT.class, gestaorecursos.model.domain.sr.RecebimentosSRIT.class, gestaorecursos.model.domain.sr.DeducoesSRIT.class})
public class SrITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
