@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
}

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}