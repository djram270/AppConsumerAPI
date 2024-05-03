package co.unicauca.microservice.apirest.model.entity;

//import co.unicauca.microservice.apirest.model.entity.states.NoSent;
//import co.unicauca.microservice.apirest.model.entity.states.OnHold;
//import co.unicauca.microservice.apirest.model.entity.states.StateOrder;
import co.unicauca.microservice.apirest.model.entity.states.NotSend;
import co.unicauca.microservice.apirest.model.entity.states.OnHold;
import co.unicauca.microservice.apirest.model.entity.states.iStateOrder;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Table(name = "order_table")
@ToString
@Getter
@Setter

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String date;
    private String strState;

    @Transient
    private iStateOrder state;

    // Constructor
    public Order() {
        // Por defecto, el estado inicial es "EsperandoPagoState"
        this.state = new NotSend();
        this.strState = state.getClass().getSimpleName();

    }

    // Métodos para cambiar de estado
    public void enviar() {
        actualizarStrState();
    }

    public void cancelOrder() {
        state.CancellOrder(this);
        actualizarStrState();
    }
    public void sendOrder() {
        state.SendOrder(this);
        actualizarStrState();
    }
    public void notSendOrder() {
        state.NotSendOrder(this);
        actualizarStrState();
    }
    public void onHold() {
        state.OnHoldOrder(this);
        actualizarStrState();
    }

    private void actualizarStrState() {
        strState = state.getClass().getSimpleName();
    }

    public void setState(iStateOrder order) {
        this.state = order;
        actualizarStrState();
    }
}

