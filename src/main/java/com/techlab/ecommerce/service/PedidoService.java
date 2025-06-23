@Service
public class PedidoService {

    private final PedidoRepository pedidoRepo;
    private final UsuarioRepository usuarioRepo;
    private final ProductoRepository productoRepo;

    public PedidoService(PedidoRepository p, UsuarioRepository u, ProductoRepository pr) {
        this.pedidoRepo = p;
        this.usuarioRepo = u;
        this.productoRepo = pr;
    }

    public Pedido crearPedido(Long usuarioId, List<LineaPedido> lineas) {
        Usuario usuario = usuarioRepo.findById(usuarioId).orElseThrow();

        double total = 0;
        for (LineaPedido linea : lineas) {
            Producto producto = productoRepo.findById(linea.getProducto().getId()).orElseThrow();

            if (producto.getStock() < linea.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - linea.getCantidad());
            total += producto.getPrecio() * linea.getCantidad();
            productoRepo.save(producto);
        }

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setEstado("pendiente");
        pedido.setTotal(total);
        pedido.setLineas(lineas);

        return pedidoRepo.save(pedido);
    }

    public List<Pedido> historial(Long usuarioId) {
        return pedidoRepo.findByUsuarioId(usuarioId);
    }
}