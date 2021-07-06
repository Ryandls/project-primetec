package br.com.bryan.primetec.enuns;

public enum EnumDefeito {

	TELA_TRINCADA(1L, "Tela Trincada"),
	CAMERA_FRONTAL(2L, "Câmera Frontal"),
	CAMERA_TRASEIRA(3L, "Câmera Traseira"),
	TOUCH_SCREEN(4L,"Touch Screen"),
	AUDIO_AURICULAR(5L,"Áudio Auricular"),
	MICROFONE(6L,"Microfone"),
	CONECTOR_CARGA(7L, "Conector de Carga"),
	ALTO_FALANTE(8L, "Alto Falante"),
	SENSOR_PROXIMIDADE(9L,"Sensor de Proximidade"),
	WIFI(10L,"Wifi"),
	BLUETOOTH(11L,"Bluetooth");

	private Long id;
	private String descricao;

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	private EnumDefeito(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public static String valueOfId(Long id) {
		for (EnumDefeito defeito : EnumDefeito.values()) {
			if(defeito.getId().equals(id)) {
				return defeito.getDescricao();
			}
		}
		return null;
	}
	
}
