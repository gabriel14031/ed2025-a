public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dimensao;

    public JogoDaVelha(int dimensao) {
        tabuleiro = new int[dimensao][dimensao];
        limpaTabuleiro();
        this.dimensao = dimensao;
        
    }

    public void limpaTabuleiro() {
        for(int i = 0;i<dimensao;i++) {
            for (int j=0;j<dimensao; j++) {
                tabuleiro[i][j]= VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i<0||i>dimensao-1||j<0||j>dimensao-1){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j]=jogador;
        jogador = -jogador;
    }


    public int vencedor() {
        int resultado = 2;
        // Implemente este método que deve retornar o vencedor ou 
        // zero em caso de empate e 2 se o jogo não acabou.
        //Passando pela linha
        for (int i = 0;i<dimensao;i++){
            int somaLinha = 0;
            for (int j = 0;j<dimensao;j++){
                somaLinha = somaLinha + tabuleiro[i][j];
                if (somaLinha == dimensao){
                    System.out.println("X venceu");
                    resultado = X;
                    break;
                }
                if (somaLinha == -dimensao){
                    System.out.println("O venceu");
                    resultado = O;
                    break;
                }
            
                }
            }
        //Passando pela coluna
        for (int i = 0;i<dimensao;i++){
            int somaColuna = 0;
            for (int j = 0;j<dimensao;j++){
                somaColuna = somaColuna + tabuleiro[j][i];
                if (somaColuna == dimensao){
                    System.out.println("X venceu");
                    resultado = X;
                    break;
                }
                if (somaColuna == -dimensao){
                    System.out.println("O venceu");
                    resultado = O;
                    break;
                }
            
                }
            }
        //Passando pela diagonais
        int somaDiagonal = 0; //A somaDiagonal está fora para não resetar o valor após passar para a próxima linha
        
        //Diagonal esquida-direita
        for (int i = 0;i<dimensao;i++){
            for (int j = 0;j<dimensao;j++){
                if (i == j){
                    somaDiagonal = somaDiagonal + tabuleiro[i][j];
                }
                if (somaDiagonal == dimensao){
                    System.out.println("X venceu");
                    somaDiagonal = 0;
                    resultado = X;
                    break;
                }
                if (somaDiagonal == -dimensao){
                    System.out.println("O venceu");
                    somaDiagonal = 0;
                    resultado = O;
                    break;
                }
            }
        }
        //Diagonal direita-esquerda
        for (int i = 0;i<dimensao;i++){
            for (int j = 0;j<dimensao;j++){
                if (i + j == dimensao-1){
                    somaDiagonal = somaDiagonal + tabuleiro[i][j];
                }
                if (somaDiagonal == dimensao){
                    System.out.println("X venceu");
                    resultado = X;
                    break;
                }
                if (somaDiagonal == -dimensao){
                    System.out.println("O venceu");
                    resultado = O;
                    break;
                }
            }
        }

        //Verificação de tabuleiro cheio
        for (int i = 0;i<dimensao;i++){
            int somaLinha = 0;
            int somaDiferente = 0;
            for (int j = 0;j<dimensao;j++){
                somaLinha = somaLinha + tabuleiro[i][j];
                if (somaLinha != dimensao){
                    somaDiferente ++;
                    break;
                }
                }
            if (somaDiferente == dimensao){
                resultado = 0;
            }
            }
        return resultado;
    }

    
    public String toString() {
        /** Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */
        String retorno = "";
        for (int i=0; i<dimensao;i++){
            for (int j=0; j<dimensao; j++){
                if(tabuleiro[i][j]==X) {
                    retorno += ("X");
                } else if (tabuleiro[i][j]==O) {
                    retorno += ("O");
                } else {
                    retorno += (" ");
                }
                if (j<dimensao){
                    retorno += ("|");
                }
            }
            //System.out.println();
            if (i<dimensao-1){
                retorno += ("\n");
                for (int j=0; j<dimensao; j++){
                    retorno += ("─┼");
                }
                retorno += ("\n");
            }

        }   
        return retorno;
        
    }
}