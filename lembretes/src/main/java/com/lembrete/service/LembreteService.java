package com.lembrete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lembrete.entity.Lembrete;
import com.lembrete.repository.LembreteRepository;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository repository;

    public List<Lembrete> findAll() {
        return repository.findAll();
    }

    public ResponseEntity<Lembrete> include(Lembrete lembrete) {
        repository.save(lembrete);
        return ResponseEntity.ok(lembrete);
    }

    public ResponseEntity<Lembrete> edit(Long id, Lembrete lembrete) {

        final Lembrete lembreteBanco = this.repository.findById(id).orElse(null);
        Assert.isTrue(lembreteBanco != null, "nao foi possivel encontrar o registro");
        Assert.isTrue(lembreteBanco.getId() != lembrete.getId(), "Os registros não coincidem");
        lembreteBanco.setMensagem(lembrete.getMensagem());
        lembreteBanco.setPessoa(lembrete.getPessoa());

        repository.save(lembreteBanco);
        return ResponseEntity.ok(lembreteBanco);
    }

    public void delete(Long id) {
        Lembrete lembreteBanco = this.repository.findById(id).orElse(null);
        Assert.isTrue(lembreteBanco != null, "nao foi possivel encontrar o registro");
        this.repository.deleteById(id);
    }
}
