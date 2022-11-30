package app;

abstract class Player {
	protected int pontos = 0;
	protected int[] coordenadas = new int[2];
	protected char orientacao;
	Mapa mapa = new Mapa();
	
	protected int getPontos() {
		return pontos;
	}

	public void ganhaPonto(int tiro) {
		if(tiro == 1) {
			this.pontos++;
		}
	}

	
}