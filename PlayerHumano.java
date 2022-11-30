package app;


public class PlayerHumano extends Player {
	

	Dialogos diag = new Dialogos();

	
	public int[] atirar (){
		diag.diagAtirar();
		this.coordenadas[1] = diag.getColuna();
		this.coordenadas[0] = diag.getLinha();
		return coordenadas;
	}
	
	public void inserirNavio() {
		for(int i = 1; i<4; i++) {
			diag.diagNavio();
			System.out.println(" "+i+":");
			inserirNavio1();
			mapa.mostraMapa();
		}
	}
	
	public void inserirNavio1() {			
			do {
				this.coordenadas[1] = diag.getColuna();	
				this.coordenadas[0] = diag.getLinha();
				this.orientacao = diag.getOrientacao();	
				if(mapa.comparaPosA(coordenadas,orientacao)==1) {
				System.out.println("Já existe navio na posição");
				}
			}while(mapa.comparaPosA(coordenadas,orientacao)==1);
			
			this.mapa.insereNavioA(this.coordenadas, this.orientacao);

		
	}
	
}