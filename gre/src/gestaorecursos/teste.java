package gestaorecursos;

import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.domain.Programa;

public class teste {


    public static void main(String[] args) {
        Programa p = new Programa();
        p.setPrograma("CONTA ESCOLA");
        
        ProgramaDAO dao = new ProgramaDAO();
        if(dao.inserir(p)){
            System.out.println("Cadastrado");
        }else{
            System.out.println("Não cadastrado");
        }
    }
    
}
