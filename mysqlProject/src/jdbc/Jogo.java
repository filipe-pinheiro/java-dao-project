package jdbc;


public class Jogo {
	
	public Jogo(){
		
	}
	
    private String codigo;
    private String nome;
    private String ano;

    public Jogo(String codigo, String nome, String ano) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Jogo [codigo=" + codigo + ", nome=" + nome + ", ano=" + ano + "]";
	}

   
	
}
