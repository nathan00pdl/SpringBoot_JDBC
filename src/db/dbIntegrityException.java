package db;

//Exceção personalizada devido a problemática da "Integridade Referencial" (FOREIGN KEY)
//Não será possível excluir uma coluna quando houver outras colunas sendo referenciadas por esta!
public class dbIntegrityException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public dbIntegrityException(String msg){
		super(msg);
	}
}
