package app;

public class Mapa{
	Dialogos diag = new Dialogos();
	private int[][] mapa = new int[11][11];
	private int temp = 64;
	private int agua = 0;
	private int navioA = 1;
	private int navioB = 2;
	private int acerto = 3;
	private int erro = 4;

	protected int[][] getMapa() {
		return mapa;
	}

	protected void setMapa(int[][] mapa) {
		this.mapa = mapa;
	}

	protected int testaMapa(int[] coordenada){
		return mapa[coordenada[0]][coordenada[1]];
	}

	public void geraMapaInicial() {
		this.mapa[0][0] = 0;
		temp = 0;
		for (int linha = 1; linha < mapa.length; linha++) {
			temp++;
			this.mapa[linha][0] = temp;
		}
		temp = 64;
		for (int coluna = 1; coluna < mapa[0].length; coluna++) {
		    	temp++;
		    	this.mapa[0][coluna] = temp;
		    }
		for (int linha = 1; linha < mapa.length; linha++) {
		    for (int coluna = 1; coluna < mapa[linha].length; coluna++) {
		        this.mapa[linha][coluna] = agua;
		    }

		}
	}
	
	public void mostraMapa() {
		for (int i = 0; i < mapa.length; i++) {
			if(i != 10) {
				System.out.print(" ");
			}
			System.out.print(mapa[i][0] + "  ");
		    for (int j = 1; j < mapa[i].length; j++) {
		    	if(mapa[i][j] == agua || mapa[i][j] == navioB) {
		    	System.out.print('~' + " ");
		    	}else if(mapa[i][j] == navioA) {
			    	System.out.print('H' + " ");
			    }else if(mapa[i][j] == acerto) {
			    	System.out.print('O' + " ");
			    }else if(mapa[i][j] == erro) {
			    	System.out.print('X' + " ");
			    }else {
			    	System.out.print((char)mapa[i][j]+ " ");
			    }
		    }
		    System.out.println();
		    }
	}
	
	public void mostraMapaLogico() {

		for (int i = 0; i < mapa.length; i++) {
			if(i != 10) {
				System.out.print(" ");
			}
			System.out.print(mapa[i][0] + "  ");
		    for (int j = 1; j < mapa[i].length; j++) {
		    	System.out.print(mapa[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	public int comparaPosA(int coordenada[],char orientacao) {
		int linha = coordenada[0];
		int coluna = coordenada[1];
		if(orientacao == 'V'){
			if(linha <= 1 ) { 
				linha++;
			}else if(linha >= 10 ) {
				linha--;
			}
		    if(this.mapa[linha][coluna] == navioA || this.mapa[linha - 1][coluna] == navioA || this.mapa[linha + 1][coluna] == navioA ) {
			    return 1;
	        	}else {
			    return 0;
	        	} 
		}else{
				if(coluna <= 1 ) { 
					coluna++;
				}else if(coluna >= 10 ) {
					coluna--;
				}
				if(this.mapa[linha][coluna] == navioA || this.mapa[linha][coluna-1] == navioA || this.mapa[linha][coluna+1] == navioA ) {
				    return 1;
		        	}else {
				    return 0;
		        	}
			}
}
	
	public int comparaPosB(int coordenada[],char orientacao) {
		int linha = coordenada[0];
		int coluna = coordenada[1];
		if(orientacao == 'V'){
			if(linha <= 1 ) { 
				linha++;
			}else if(linha >= 10 ) {
				linha--;
			}
		    if(this.mapa[linha][coluna] == navioB || this.mapa[linha - 1][coluna] == navioB || this.mapa[linha + 1][coluna] == navioB ) {
			    return 1;
	        	}else {
			    return 0;
	        	} 
		}else{
				if(coluna <= 1 ) { 
					coluna++;
				}else if(coluna >= 10 ) {
					coluna--;
				}
				if(this.mapa[linha][coluna] == navioB || this.mapa[linha][coluna-1] == navioB || this.mapa[linha][coluna+1] == navioB ) {
				    return 1;
		        	}else {
				    return 0;
		        	}
			}
}
	public void insereNavioA(int coordenada[], char orientacao) {
		int linha = coordenada[0];
		int coluna = coordenada[1];
		if(orientacao == 'V') {
				if(linha <= 1 ) { 
					linha++;
				}else if(linha >= 10 ) {
					linha--;
				}
				this.mapa[linha][coluna] = navioA;
				this.mapa[linha - 1][coluna] = navioA;
				this.mapa[linha + 1][coluna] = navioA;
				System.out.println("Navio inserido com sucesso!");
		}else if(orientacao == 'H') {
			if(coluna <= 1 ) {
				coluna++;
			}else if(coluna >= 10) {
				coluna --;
			}
				this.mapa[linha][coluna] = navioA;
				this.mapa[linha][coluna -1] =navioA;
				this.mapa[linha][coluna +1] =navioA;
				System.out.println("Navio inserido com sucesso!");
			
			}
		}
	
	public void insereNavioB(int coordenada[], char orientacao) {
		int linha = coordenada[0];
		int coluna = coordenada[1];
		if(orientacao == 'V') {
				if(linha <= 1 ) { 
					linha++;
				}else if(linha >= 10 ) {
					linha--;
				}
				this.mapa[linha][coluna] = navioB;
				this.mapa[linha - 1][coluna] = navioB;
				this.mapa[linha + 1][coluna] = navioB;
		}else if(orientacao == 'H') {
			if(coluna <= 1 ) {
				coluna++;
			}else if(coluna >= 10) {
				coluna --;
			}
				this.mapa[linha][coluna] = navioB;
				this.mapa[linha][coluna -1] =navioB;
				this.mapa[linha][coluna +1] =navioB;
			}
		}
	

	public int insereTiro(int coordenada[]) {
		if(this.mapa[coordenada[0]][coordenada[1]] == 1 || this.mapa[coordenada[0]][coordenada[1]] == 2) {
			this.mapa[coordenada[0]][coordenada[1]] = acerto;
			return 1;
		}else {
			this.mapa[coordenada[0]][coordenada[1]] = erro;
			return 2;
			}
	}
	
	public int testaPosTiro(int coordenada[]) {
		if(this.mapa[coordenada[0]][coordenada[1]] == 3 || this.mapa[coordenada[0]][coordenada[1]] == 4) {
			return 0;
		}else {
			return 1;
			}
	}
	

	

	
	/* ~ agua
	 * H navio
	 * O acerto
	 * X erro
	 * 
	 */
	

	
	
}