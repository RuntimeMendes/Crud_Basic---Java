package br.com.ricardo.DAO;

import java.util.List;

import br.com.ricardo.modelBean.Contato;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO();	
		
		
		contato.setNome("David Mendes");
		contato.setEmail("dmendes@live.com");
		contato.setEndereco("rua:damiao soares de frança");
		contato.setId(7l);
		
		   //dao.Create(c);
		  dao.Update(contato);		  
		  // dao.pesquisar(7);			  
		//  dao.Remover(4);
		  
      	}
		  

	}


