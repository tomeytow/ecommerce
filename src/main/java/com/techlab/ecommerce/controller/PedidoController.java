import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.techlab.ecommerce.service.PedidoService;
import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.LineaPedido;

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