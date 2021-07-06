package br.com.bryan.primetec.enuns;

public enum EnumEmailConfig {

	HOST(null ,"smtp.live.com"),
	PORT(null ,"587"),
	USERNAME_EMAIL(null, "primetec.sobradinho@hotmail.com"),
	PASSWORD(null, "Prime@123"),
	TRANSPORT_PROTOCOL("mail.transport.protocol","smtp"),
	SMTP_HOST("mail.smtp.host", "smtp.live.com"),
	SOCKETFACTORY_PORT("mail.smtp.socketFactory.port" ,"587"),
	SOCKETFACTORY_FALLBACK("mail.smtp.socketFactory.fallback","false"),
    SMTP_STARTTLSENABLE("mail.smtp.starttls.enable","true"),
    SMTP_AUTH("mail.smtp.auth","true"),
    SMTP_PORT("mail.smtp.port","587");


	private String propriedade;
	private String valor;
	private EnumEmailConfig(String propriedade, String valor) {
		this.propriedade = propriedade;
		this.valor = valor;
	}
	public String getPropriedade() {
		return propriedade;
	}
	public String getValor() {
		return valor;
	}
	
	
	
}
