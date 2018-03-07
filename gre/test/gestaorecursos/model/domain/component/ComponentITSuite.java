/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.model.domain.component;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.model.domain.component.TextFieldFormatterIT.class, gestaorecursos.model.domain.component.ColunaValorIT.class, gestaorecursos.model.domain.component.ConversorDataIT.class, gestaorecursos.model.domain.component.AutoCompleteComboBoxListenerIT.class, gestaorecursos.model.domain.component.ImprimirIT.class})
public class ComponentITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
