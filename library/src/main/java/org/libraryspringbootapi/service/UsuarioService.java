package org.libraryspringbootapi.service;


import org.libraryspringbootapi.model.entity.Usuario;
import org.libraryspringbootapi.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new Exception("Usuário não encontrado");
        }
        return usuario.get();
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (usuario.getSobrenome() == null) {
            throw new Exception("Sobrenome inválido. Digite um sobrenome válido.");
        }

        if (usuario.getEndereco() == null) {
            throw new Exception("Endereço inválido. Digite um endereço válido.");
        }

        if (usuario.getNumeroEndereco() == null) {
            throw new Exception("Numeração do Endereço inválido. Digite um número válido.");
        }

        if (usuario.getCidade() == null) {
            throw new Exception("Cidade inválida. Digite uma cidade válida.");
        }

        if (usuario.getUf() == null) {
            throw new Exception("Uf inválida. Digite uma Uf válida.");
        }

        if (usuario.getCep() == null) {
            throw new Exception("Cep inválido. Digite um cep válido.");
        }

        if (usuario.getTelefone() == null) {
            throw new Exception("Telefone inválida. Digite uma cidade válida.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("E-mail inválido. Digite um e-mail válido.");
        }


        Optional<Usuario> usuarioTemp = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioTemp.isPresent()) {
            if (!Long.valueOf(usuario.getId()).equals(usuarioTemp.get().getId())) {
                throw new Exception("O email fornecido já está em uso.");
            }
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario delete(Long id) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new Exception("Usuário não encontrado");
        }
        usuarioRepository.delete(usuario.get());
        return usuario.get();
    }

    public Long count() {
        return usuarioRepository.count();
    }
}
