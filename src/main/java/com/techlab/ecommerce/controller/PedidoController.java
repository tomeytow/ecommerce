@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService servicio;

    public PedidoController(PedidoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/{usuarioId}")
    public Pedido crear(@PathVariable Long usuarioId, @RequestBody List<LineaPedido> lineas) {
        return servicio.crearPedido(usuarioId, lineas);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> historial(@PathVariable Long usuarioId) {
        return servicio.historial(usuarioId);
    }
}