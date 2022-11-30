package app;
import java.util.concurrent.TimeUnit;

public class Controlador {
	private int op;
	PlayerHumano p1 = new PlayerHumano();
	PlayerMaquina p2 = new PlayerMaquina();
	
	public void inicioJogo() {
		op = p1.diag.menuInicial();
		if(op == 2) {

		}else {
			criaJogo();
			mostraJogo();
			posicionaNavios();
			mostraJogo();
			executaRodada();
			fimDeJogo();
		}
	}
	
	public void criaJogo() {
		p1.mapa.geraMapaInicial();
		p2.mapa.geraMapaInicial();	
	}
	public void mostraJogo() {
		clearScreen();
		System.out.println("ADVERSÁRIO_____Acertos:"+p2.getPontos());
		p2.mapa.mostraMapa();
		System.out.println("========================");
		System.out.println("JOGADOR________Acertos:"+p1.getPontos());
		p1.mapa.mostraMapa();
	}
    public void posicionaNavios() {
		p2.inserirNavio();	
		p1.inserirNavio();
	}
    
	public void tiroP1() {
		do{
			p1.atirar();
			if(p2.mapa.testaMapa(p1.coordenadas) == 3 || p2.mapa.testaMapa(p1.coordenadas) == 4)
				p1.diag.tiroInvalido();
		}while(p2.mapa.testaMapa(p1.coordenadas) == 3 || p2.mapa.testaMapa(p1.coordenadas) == 4);
		p1.ganhaPonto(p2.mapa.insereTiro(p1.coordenadas));
	}	
	
	public void tiroP2() {
		do {
			p2.atirar();
		}while(p1.mapa.testaMapa(p2.getBaseCoordenada()) == 3 || p1.mapa.testaMapa(p2.getBaseCoordenada()) == 4);			
		if(p2.getPadrao() == 0) {
			p2.ganhaPonto(p1.mapa.insereTiro(p2.coordenadas));
			if(p1.mapa.testaMapa(p2.coordenadas) == 3) {
				p2.setPadrao(1);
			}else{
				p2.setPadrao(0);
			}
		}else if(p2.getPadrao()!=0) {
			p2.ganhaPonto(p1.mapa.insereTiro(p2.getBaseCoordenada()));
			if(p1.mapa.testaMapa(p2.getBaseCoordenada()) == 3) {
				p2.setPadrao(p2.getPadrao()+1);
			}else if(p2.getPadrao()==7 && p1.mapa.testaMapa(p2.getBaseCoordenada()) == 4 ) {
				p2.setPadrao(10);
			}else if(p2.getPadrao()==1 && p1.mapa.testaMapa(p2.getBaseCoordenada()) == 4) {
				p2.setPadrao(4);
			}else if(p2.getPadrao()==6 && p1.mapa.testaMapa(p2.getBaseCoordenada()) == 4 ) {
				p2.setPadrao(7);
			}else if(p2.getPadrao()== 4 && p1.mapa.testaMapa(p2.getBaseCoordenada()) == 4 ) {
				p2.setPadrao(7);
			}else {
				p2.setPadrao(p2.getPadrao()+2);
			}
		}else {
			p2.setPadrao(0);
		}
	}
	
	public void executaRodada() {
		while(p1.getPontos()!=9 && p2.getPontos()!=9) {
			p2.mapa.mostraMapaLogico();
			mostraJogo();
			tiroP1();
			mostraJogo();
			System.out.println("VOCÊ ATIROU!");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();}
			tiroP2();
			mostraJogo();
			System.out.println("ADVERSÁRIO ATIROU!");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();}

		}
		
	}
	
	public void fimDeJogo() {
		p1.diag.fimDeJogo(p1.getPontos());	
	}
	
	
	
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}  
	
	public void mostraMapaLogico() {
		p2.mapa.mostraMapaLogico();
	}

}

