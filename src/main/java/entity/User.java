package entity;

public class User {
	
	private int id;
	private String nome;
	private String fase;
	private String pontuacao;
	
	public User (int id, String nome, String fase, String pontuacao) {
		this.id = id;
		this.nome = nome;
		this.fase = fase;
		this.pontuacao = pontuacao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getFase() {
		return fase;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", fase=" + fase + ", pontuacao=" + pontuacao + "]";
	}
	
}
