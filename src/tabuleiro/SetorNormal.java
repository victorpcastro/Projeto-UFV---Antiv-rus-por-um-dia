/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetorNormal extends Setor {
    
    public SetorNormal(){}
    
    public SetorNormal(int coordenadaX, int coordenadaY, boolean ladoEsq, boolean ladoBaixo, boolean ladoDir, boolean ladoCima)
    {
        super(coordenadaX, coordenadaY, ladoEsq, ladoBaixo, ladoDir, ladoCima);
    }
    
    // Função para gerar as coordenadas da fonte do Vírus na matriz
    public SetorNormal gerarSetorFonte(SetorNormal setorFonte, Tabuleiro tabu)
    {
        // Adicionando os números que podem ser sorteados para coordenada X
        List<Integer> numerosLinha = new ArrayList<Integer>();
        for(int i=1;i<=9;i=i+2)
        {
            numerosLinha.add(i);
        }
        
        //Pegando numero da linha aleatoriamente
        int coordenadaX = numerosLinha.get(new Random().nextInt(numerosLinha.size()));
        
        // Adicionando os números que podem ser sorteados para coordenada Y
        List<Integer> numerosColuna = new ArrayList<Integer>();
        if(coordenadaX == 5)
        {
            for(int i=2;i<=20;i=i+4)
            {
                if(i!=10)
                {
                    numerosColuna.add(i);
                }
            }
        }
        else
        {
            for(int i=2;i<=20;i=i+4)
            {
                numerosColuna.add(i);
            }
        }
        
        //Pegando numero da coluna aleatoriamente
        int coordenadaY = numerosColuna.get(new Random().nextInt(numerosColuna.size()));
        
        //Setando os valores no Setor Fonte
        setorFonte.setCoordenadaX(coordenadaX);
        setorFonte.setCoordenadaY(coordenadaY);
        setorFonte.setLadoCima(true);
        setorFonte.setLadoDir(true);
        setorFonte.setLadoBaixo(true);
        setorFonte.setLadoEsq(true); 
        
        tabu.setoresVisitados.add(setorFonte);
        
        return setorFonte;
    }

    @Override
    public Setor getSetorPorCoordenada(String coordenada, Tabuleiro tabu) {
        return super.getSetorPorCoordenada(coordenada, tabu); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initSetor(String posicaoNova, Tabuleiro tabu, int comando, Setor novoSetor) {
        super.initSetor(posicaoNova, tabu, comando, novoSetor); //To change body of generated methods, choose Tools | Templates.
    }
    
}