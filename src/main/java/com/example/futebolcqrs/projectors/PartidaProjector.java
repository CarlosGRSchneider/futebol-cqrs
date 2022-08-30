package com.example.futebolcqrs.projectors;

import com.example.futebolcqrs.entidadesRead.PartidaRead;
import com.example.futebolcqrs.entidadesRead.TimeRead;
import com.example.futebolcqrs.entidadesWrite.Partida;
import com.example.futebolcqrs.repositoriosRead.JogadorReadRepository;
import com.example.futebolcqrs.repositoriosRead.PartidaReadRepository;
import com.example.futebolcqrs.repositoriosRead.TimeReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PartidaProjector implements Projector<Partida>{

    @Autowired
    private PartidaReadRepository repository;

    @Autowired
    private TimeReadRepository timeRepository;

    @Autowired
    private JogadorReadRepository jogadorRepository;

    @Override
    public void project(Partida partida) {

        TimeRead timeCasa = timeRepository.findById(partida.getTimeCasa().getId()).get();
        TimeRead timeRival = timeRepository.findById(partida.getTimeRival().getId()).get();

        PartidaRead partidaRead = new PartidaRead(partida.getId(), timeCasa, timeRival,
                partida.getGolsTimeCasa(), partida.getGolsTimeRival(),
                partida.getCartaoAmareloTimeCasa(), partida.getCartaoAmareloTimeRival(),
                partida.getCartaoVermelhoTimeCasa(), partida.getCartaoVermelhoTimeRival(),
                partida.getPenaltiTimeCasa(), partida.getPenaltiTimeRival());

        repository.save(partidaRead);
        distribuiGols(partidaRead);
    }

    private void distribuiGols(PartidaRead partida) {

        Random random = new Random();

        int golsTimeCasa = partida.getGolsTimeCasa();

        while (golsTimeCasa > 0) {

            partida.getTimeCasa().getJogadores()
                    .get(random.nextInt(partida.getTimeCasa().getJogadores().size()))
                    .adicionaGols(1);

            golsTimeCasa--;
        }

        int golsTimeRival = partida.getGolsTimeRival();

        while (golsTimeRival > 0) {

            partida.getTimeRival().getJogadores()
                    .get(random.nextInt(partida.getTimeRival().getJogadores().size()))
                    .adicionaGols(1);

            golsTimeRival--;
        }

        jogadorRepository.saveAll(partida.getTimeCasa().getJogadores());
        jogadorRepository.saveAll(partida.getTimeRival().getJogadores());
    }
}
