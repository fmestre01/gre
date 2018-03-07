package gestaorecursos.model.domain.component;

import gestaorecursos.model.database.ConnectionFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mgonc
 */
public class Imprimir extends Thread {

    public void ImprimirPagamentosCE() {
        
    }

    public void ImprimirBens() {

     
    }
}

/*
    
        //  ******* MÉTODO 6 **********
        Connection con = ConexaoDB.getConnection();
        String src = "C:/Users/mgonc/Documents/NetBeansProjects/gre/src/gestaorecursos/relatorios/Teste.jasper";

        JasperPrint jasperPrint = null;

        try {
            jasperPrint = JasperFillManager.fillReport(src, null, con);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);

        view.setVisible(true);

        //  ******* MÉTODO 1 SPANISH USER **********
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("/gestaorecursos/relatorios/Pagamentos.jrxml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map parameters = new HashMap();

        JasperDesign jasperDesign = null;
        try {
            jasperDesign = JRXmlLoader.load(inputStream);
        } catch (JRException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperReport jasperReport = null;
        try {
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        } catch (JRException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
        } catch (JRException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

        JasperViewer view = new JasperViewer(jasperPrint, false);

        view.setVisible(true);


    
//  ******* MÉTODO 2 JAVAFX MVC**********
        Connection con = ConnectionFactory.getConnection();
        
        URL url = getClass().getResource("/gestaorecursos/relatorios/RelPagamentosCE.jasper");
        
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);

        JasperViewer view = new JasperViewer(jasperPrint, false);

        view.setVisible(true);
  
        
        //  ******* MÉTODO 3 SISTEMA OS (EXEMPLO)**********
        Connection con = ConnectionFactory.getConnection();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("/gestaorecursos/relatorios/RelPagamentosCE.jasper", null, con);

            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException ex) {
            System.out.println("Erro: " + ex);
        }
  
        //  ******* MÉTODO 4 (EXEMPLO)**********

        Connection con = ConnectionFactory.getConnection();
        
        URL url = getClass().getResource("/gestaorecursos/relatorios/RelPagamentosCE.jasper");

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);

        JasperViewer.viewReport(jasperPrint, false);
        
        
        //   ******* MÉTODO 5 (EXEMPLO GUJ)**********
        try {
            URL arquivo = getClass().getResource("/gestaorecursos/relatorios/RelPagamentoscE.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
            Map map = null;
            Connection con = null;

            // Aqui eu estou passando um jasperReport. Mas eu testei com um inputStream como Cristiano.Zanata disse e funcionada tbm. :)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRDataSource() {
                private int max = 3;
                private int cont = 0;
                private String valor;

                @Override
        public Object getFieldValue(JRField jrField) throws JRException {
                    return "main";
                }

                @Override
        public boolean next() throws JRException {
                    // TODO Auto-generated method stub
                    if (cont++ >= max) {
                        System.out.println("false");
                        return false;
                    } else {
                        System.out.println("true");
                        return true;
                    }
                }
            });
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
        

} catch (JRException ex) {
            Logger.getLogger(RelPrestacaoContasController.class
.getName()).log(Level.SEVERE, null, ex);
        }


        //   ******* MÉTODO 6 (EXEMPLO GUJ)**********
        Connection con = ConnectionFactory.getConnection();
        Map parameters = new HashMap();
        //Arquivo .jasper foi colocado no mesmo pacote da class
        String path = ("src/gestaorecursos/relatorios/GRE/RelPagamentosCE.jasper");

        File file = new File(path);
        file = file.getAbsoluteFile();

        String repStr2 = file.getPath();
        try {
            JasperFillManager.fillReportToFile(repStr2, parameters, con);
            JasperPrint jasperPrint = JasperFillManager.fillReport(repStr2, parameters, con);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
        } catch (JRException jex) {
            System.out.print("JasperException" + jex.getMessage());
        } catch (Exception ex) {
            System.out.print("-" + ex.getMessage());
        }    
        //  ******* MÉTODO ALURA **********
        try (Connection conexao = ConexaoDB.getConnection()) {
            String src = "relpagamentosce.jasper";

            JasperPrint jasperPrint = JasperFillManager.fillReport(src, null, conexao);

           JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);

    //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load("C:/Users/mgonc/Documents/NetBeansProjects/gre/src/gestaorecursos/relatorios/Teste.jrxml");

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);

        //estabelece conexão
        Connection con = ConexaoDB.getConnection();
        Statement stm = con.createStatement();
        String query = "select * from tb_saldos";
        ResultSet rs = stm.executeQuery(query);

        //implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        //executa o relatório
        Map parametros = new HashMap();

        parametros = null;

        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);

        viewer.setVisible(true);



// (validÃ© avec jasperreports-1.2.6.jar - LY 09/2006)<br />
<br />
//<br />
// Exemple de fichier CSV utilisÃ© en entrÃ©e :<br />
// => ne pas oublier le caractÃ¨re sÃ©parateur en fin de ligne !<br />
//<br />
// 	animal;mange;couleur;<br />
// 	sanglier;glands;beige;<br />
// 	vache;herbe;blanche;<br />
// 	chat;souris;gris;<br />
//<br />
<br />
import java.io.*;<br />
<br />
// import de la classe "HashMap" pour l'envoi de paramÃ¨tres Ã un rapport<br />
import java.util.HashMap;<br />
<br />
// import du moteur de la librairie JasperReports<br />
import net.sf.jasperreports.engine.*;<br />
import net.sf.jasperreports.engine.data.JRCsvDataSource;<br />
import net.sf.jasperreports.engine.design.JasperDesign;<br />
import net.sf.jasperreports.engine.design.JRDesignField;<br />
//import net.sf.jasperreports.engine.export.JRCsvExporter;<br />
//import net.sf.jasperreports.engine.export.JRPdfExporter;<br />
import net.sf.jasperreports.engine.export.JRRtfExporter;<br />
import net.sf.jasperreports.engine.xml.JRXmlLoader;<br />
<br />
public class generatepdffromcsv<br />

	public static void main(String[] args)
	
		HashMap params = new HashMap();
		
		try{	
			JasperDesign jasperDesign = JRXmlLoader.load("essai11.jrxml"Â«Â»);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			System.out.println(" : OK"Â«Â»);
			
			System.out.print("+ dÃ©claration de la source de donnÃ©es CSV"Â«Â»);
			File sourceFile = new File("essai1.csv"Â«Â»);
			JRCsvDataSource source = new JRCsvDataSource(sourceFile);
			source.setFieldDelimiter(';');
			source.setUseFirstRowAsHeader(true);
			System.out.println(" : OK"Â«Â»);
			
			System.out.print("+ export du rapport au format intermÃ©diaire 'jasperPrint'"Â«Â»);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, source);
			
		}
		catch (Exception e)
		
			System.out.println(e.getMessage());
		
	}
}
 */
