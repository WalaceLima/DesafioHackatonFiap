package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva {

    private final ListarQuartosPorPeriodoDisponibilidadeUseCase listarQuartosPorPeriodoDisponibilidadeUseCase;

    public ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva(ListarQuartosPorPeriodoDisponibilidadeUseCase listarQuartosPorPeriodoDisponibilidadeUseCase) {
        this.listarQuartosPorPeriodoDisponibilidadeUseCase = listarQuartosPorPeriodoDisponibilidadeUseCase;
    }


    public List<List<Quarto>> execute(LocalDate dataInicial, LocalDate dataFinal, Integer quantidadePessoas, Integer numeroCombinacoes){

        List<Quarto> quartosDisponiveis = this.listarQuartosPorPeriodoDisponibilidadeUseCase.execute(dataFinal, dataFinal, Status.DISPONIVEL);
        List<List<Quarto>> combinations = geraCombinacoes(quantidadePessoas, quartosDisponiveis);
        return  combinations.subList(0, numeroCombinacoes);

    }

    private List<List<Quarto>> geraCombinacoes(int quantidadePessoas, List<Quarto> candidatos) {
        List<List<Quarto>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Quarto>(), candidatos, quantidadePessoas, 0);
        return result;
    }

    private void backtrack(List<List<Quarto>> result, List<Quarto> tempList, List<Quarto> candidates, int quantidadePessoas, int start) {
        if (quantidadePessoas < 0) {
            return;
        } else if (quantidadePessoas == 0) {
            result.add(new ArrayList<Quarto>(tempList));
        } else {
            for (int i = start; i < candidates.size(); i++) {

                if (i > start && candidates.get(i) == candidates.get(i-1)) {
                    continue;
                }
                tempList.add(candidates.get(i));
                backtrack(result, tempList, candidates, quantidadePessoas - candidates.get(i).getTipoQuarto().getCapacidadeTotal(), i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
