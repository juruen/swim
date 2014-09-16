package eu.toolchain.swim.messages;

import java.util.Collection;
import java.util.UUID;

import eu.toolchain.swim.NodeState;
import lombok.Data;

@Data
public class Ack {
    private final UUID id;
    private final boolean alive;
    private final Collection<Gossip> payloads;

    /*
     * An ACK can explicitly say that a peer is 'dead'.
     */
    public NodeState toNodeState() {
        return alive ? NodeState.ALIVE : NodeState.CONFIRM;
    }
}