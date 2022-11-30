package app;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Dialogos {
	
	Scanner sc = new Scanner(System.in);
	private char entrada;
	private int numero;	
	
	public void diagAtirar() {
		System.out.println("Informe coordenadas do tiro:");
	}
	
	public void diagNavio() {
		System.out.print("Informe coordenadas do navio");
	}
	
	public int getLinha() {
			do {
				System.out.println("LINHA: ");
				try {
					this.numero = Integer.parseInt(sc.next());
				}catch (NumberFormatException e) {
					System.out.print("Erro. Por favor, insira a ");
					return getLinha();
				}
				if(this.numero>10 || this.numero<1) {
					System.out.print("Erro. Por favor, insira a ");
				}
			}while(this.numero>10 || this.numero<1);
				return this.numero;
	}
	
	public int getColuna() {
		do {
			System.out.println("Coluna: ");
			this.entrada = sc.next().charAt(0);
			if(this.entrada>106 || this.entrada<65) {
				System.out.print("Erro. Por favor, insira a ");
			}else{
				this.numero = converteChar(this.entrada);
			}
		}while(this.entrada>106 || this.entrada<65);
		return this.numero;
	}
	
	public void tiroInvalido(){
		System.out.println("Posição inválida.Tente novamente.");
	}
	
	public char getOrientacao() {
		System.out.println("Insira a orientação: V ou H");
		do {
			System.out.println("ORIENTAÇÃO:");
			this.entrada = checaMaiusculo(sc.next().charAt(0));
			if(this.entrada != 'V' && this.entrada != 'H') {
				System.out.print("Erro. Por favor, insira a ");
			}	
		}while(this.entrada != 'V' && this.entrada != 'H');
		return this.entrada;
	}
	
	private int converteChar(char entrada) {
		if(entrada >= 65 && entrada <= 74) {
			entrada -= 64;
			this.numero = entrada;
		}else if(entrada >= 97 && entrada <= 118) {
			entrada -= 96;
			this.numero = entrada;
		}else if(entrada >= 48 && entrada <= 57){
			entrada -= 48;
			this.numero = entrada;
		}
		return numero;
	}
	
	private char checaMaiusculo(char entrada) {
		if(entrada >= 97 && entrada <= 118) {
			return entrada -= 32;
		}else {
			return entrada;
		}
	}
	
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}  
		
	public void animacaoFinal() {
		clearScreen();
		printaNavio0();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		clearScreen();
		printaNavio1();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		clearScreen();
		printaNavio2();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		clearScreen();
		printaNavio3();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		clearScreen();
		printaNavio4();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	public void printaNavio0() {
		System.out.println("                                     |__\r\n"
				+ "                                     |\\/\r\n"
				+ "                                     ---\r\n"
				+ "                                     / | [\r\n"
				+ "                              !      | |||\r\n"
				+ "                            _/|     _/|-++'\r\n"
				+ "                        +  +--|    |--|--|_ |-\r\n"
				+ "                     { /|__|  |/\\__|  |--- |||__/\r\n"
				+ "                    +---------------___[}-_===_.'____                 /\\\r\n"
				+ "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "|                                                                     BB-61/\r\n"
				+ " \\_________________________________________________________________________|");
	
	
	
	
	}
	public void printaNavio1() {
		System.out.println("                          :                         \n"
				+ "                                                    \n"
				+ "                          :                         \n"
				+ "                          O          |__\r\n"
				+ "                                     |\\/\r\n"
				+ "                                     ---\r\n"
				+ "                                     / | [\r\n"
				+ "                              !      | |||\r\n"
				+ "                            _/|     _/|-++'\r\n"
				+ "                        +  +--|    |--|--|_ |-\r\n"
				+ "                     { /|__|  |/\\__|  |--- |||__/\r\n"
				+ "                    +---------------___[}-_===_.'____                 /\\\r\n"
				+ "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "|                                                                     BB-61/\r\n"
				+ " \\_________________________________________________________________________|");
	
	
	
	
	}
	public void printaNavio2() {
		System.out.println("                                     |__\r\n"
				+ "                           :         |\\/\r\n"
				+ "                                     ---\r\n"
				+ "                           :         / | [\r\n"
				+ "                           O  !      | |||\r\n"
				+ "                            _/|     _/|-++'\r\n"
				+ "                        +  +--|    |--|--|_ |-\r\n"
				+ "                     { /|__|  |/\\__|  |--- |||__/\r\n"
				+ "                    +---------------___[}-_===_.'____                 /\\\r\n"
				+ "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "|                                                                     BB-61/\r\n"
				+ " \\_________________________________________________________________________|");
	
	
	
	
	}
	public void printaNavio3() {
		System.out.println("                   .                 |__\r\n"
				+ "              .         .        .   |\\/\r\n"
				+ "                  .        **        ---\r\n"
				+ "             .     ***        *** .  / | [\r\n"
				+ "                    *****   ****     | |||\r\n"
				+ "                .     *********  .  _/|-++'\r\n"
				+ "                   *   ******* *   |--|--|_ |-\r\n"
				+ "                     {   *****  \\__|  |--- |||__/\r\n"
				+ "                    +---  ***  -----___[}-_===_.'____                 /\\\r\n"
				+ "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\r\n"
				+ "|                                                                     BB-61/\r\n"
				+ " \\_________________________________________________________________________|");
	
	
	
	
	}
	public void printaNavio4() {
		System.out.println("   "
				+ "   .        *s*     .      *s*    *s**\n"
				+ "	 .     *s***s**   .  . *s***s***s**\n"
				+ "       ***s**s*s**s***s    **s*s***\n"
				+ "   .  **s****s**s****s**  *s**s***s  |__\r\n"
				+ "            . **s*s****s* ***s**s*** |\\/\r\n"
				+ "    ,   .       . **s**    **s***    ---\r\n"
				+ "            ,       *s*    *s**s*  . / | [\r\n"
				+ "       .   ..   .   **s**   *s**  .  | |||\r\n"
				+ "   ,       .        . **s***s**     _/|-++'\r\n"
				+ "       .       ,   *   **s*s** *   |--|--|_ |-\r\n"
				+ "    .           .    {   *s*s*  \\__|  |--- |||__/\r\n"
				+ "          .         +---  ***  -----___[}-_===_.'____                 /\\\r\n"
				+ "    .           ____`-' ||_s_-{]_| _[}-  |     |_[___\\==--            \\/   _\r\n"
				+ " __..._____--==/___]_|__|_*s_*________________________[___\\==--____,------' .7\r\n"
				+ "|                    *   * ss* *                                      BB-61/\r\n"
				+ " \\_____________________*_ssss__*___________________________________________|");
	
	
	
	
	}
		
	public int menuInicial() {
		int op;
		System.out.println("Bem vim ao Batalha Naval A3!\n\n  1. Novo Jogo\n  2. Carregar Jogo\n\nDigite a opção pelo índice: ");
		do {
			try {
				op = Integer.parseInt(sc.next());
			}catch (NumberFormatException e) {
				return menuInicial();
			}
		}while(op > 2 || op < 1);
		return op;
	}
	
	
	
	public void fimDeJogo(int ponto) {
		if(ponto == 9) {
			animacaoFinal();
			System.out.println("                       PARABÉNS! VOCÊ VENCEU!                                    ");
		}else {
			animacaoFinal();
			System.out.println("                             VOCÊ PERDEU!                                        ");
		}
		
	}
	
	
	
}