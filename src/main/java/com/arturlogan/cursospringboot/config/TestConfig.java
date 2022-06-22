package com.arturlogan.cursospringboot.config;

import com.arturlogan.cursospringboot.entitites.Categoria;
import com.arturlogan.cursospringboot.entitites.Pedido;
import com.arturlogan.cursospringboot.entitites.Usuario;
import com.arturlogan.cursospringboot.entitites.enuns.PedidoStatus;
import com.arturlogan.cursospringboot.repositories.CategoriaRepository;
import com.arturlogan.cursospringboot.repositories.PedidoRepository;
import com.arturlogan.cursospringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livro");
        Categoria cat3 = new Categoria(null, "Computadores");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}