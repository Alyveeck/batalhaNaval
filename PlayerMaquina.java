package app;
import java.util.Random;

public class PlayerMaquina extends Player {
	Random random = new Random();
	private int padrao = 0;
	private int[] baseCoordenada = new int[2];
	
	protected int getPadrao() {
		return padrao;
	}

	protected void setPadrao(int padrao) {
		this.padrao = padrao;
	}
	
	protected void getRandomCoordenadas() {
		this.coordenadas[0] = (int)Math.floor(Math.random()*(10-1+1)+1);
		this.coordenadas[1] = (int)Math.floor(Math.random()*(10-1+1)+1);
	}

	protected int[] getBaseCoordenada() {
		return baseCoordenada;
	}
	protected void setBaseCoordenada(int[] baseCoordenada) {
		this.baseCoordenada = baseCoordenada;
	}

	protected void procuraNavio() {
		if(this.padrao==0) {
			getRandomCoordenadas();
			this.baseCoordenada = this.coordenadas;
		}else if(this.padrao == 7) {
			this.baseCoordenada[0] = this.coordenadas[0] + 1;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 8) {
			this.baseCoordenada[0] = this.coordenadas[0] + 2;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 9) {
			this.baseCoordenada[0] = this.coordenadas[0] + 3;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 10) {
			this.baseCoordenada[0] = this.coordenadas[0] - 1;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 11) {
			this.baseCoordenada[0] = this.coordenadas[0] - 2;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 12) {
			this.baseCoordenada[0] = this.coordenadas[0] - 3;
			this.baseCoordenada[1] = this.coordenadas[1];
		}else if(this.padrao == 1) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] + 1;
		}else if(this.padrao == 2) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] + 2;
		}else if(this.padrao == 3) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] + 3;
		}else if(this.padrao == 4) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] - 1;
		}else if(this.padrao == 5) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] - 2;
		}else if(this.padrao == 6) {
			this.baseCoordenada[0] = this.coordenadas[0];
			this.baseCoordenada[1] =	this.coordenadas[1] - 3;
		}else {
			this.padrao = 0;
			getRandomCoordenadas();
			this.baseCoordenada = this.coordenadas;
		}
		
	}


	public int[] atirar() {
		if(this.padrao <= 0) {
			getRandomCoordenadas();
			return this.coordenadas;
		}else{
			do {		
			procuraNavio();
			if(this.baseCoordenada[0] < 1 ) { 
				this.padrao++;
				//this.padrao = 0;

			}else if(this.baseCoordenada[0] > 10) {
				this.padrao++;
				//this.padrao = 10;

			}
			if(this.baseCoordenada[1] < 1 ) { 
				this.padrao++;
				//this.padrao = 7;

			}else if(this.baseCoordenada[1] > 10) {
				this.padrao++;
				//	this.padrao = 4;
			}
			}while(this.baseCoordenada[0] < 1 || this.baseCoordenada[0] > 10 || this.baseCoordenada[1] < 1 || this.baseCoordenada[1] > 10 );
			return this.baseCoordenada;
		}
	}
	
	public void inserirNavio() {
		for(int i = 1; i<4; i++) {
			geraPosicaoNavio();
		}
	}

	
	public void geraPosicaoNavio() {	
		if(((int)Math.floor(Math.random()*(2-1+1)+1) == 1)) {
			orientacao = 'V';
		}else {
			orientacao = 'H';
		}
		do {
			getRandomCoordenadas();
		}while(mapa.comparaPosB(coordenadas,orientacao)==1);
		this.mapa.insereNavioB(coordenadas, orientacao);
		}		

	/*	public int[] atirar() {
		if(this.padrao <= 0) {
			getRandomCoordenadas();
			return this.coordenadas;
		}else{
			this.coordenadas[0] +=(int)Math.floor(Math.random()*(1-(-1)+1)+(-1));	
			if(this.coordenadas[0] == 0 ) { 
				this.coordenadas[0]++;
			}else if(this.coordenadas[0] > 10) {
				this.coordenadas[0]--;
			}
			this.coordenadas[1] +=(int)Math.floor(Math.random()*(1-(-1)+1)+(-1));	
			if(this.coordenadas[1] == 0 ) { 
				this.coordenadas[1]++;
			}else if(this.coordenadas[1] > 10) {
				this.coordenadas[1]--;
			}
		return this.coordenadas;
		}
	}*/
}
