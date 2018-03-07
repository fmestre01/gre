/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.model.database;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mgonc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gestaorecursos.model.database.ConnectionFactoryIT.class, gestaorecursos.model.database.ConexaoDBIT.class})
public class DatabaseITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
