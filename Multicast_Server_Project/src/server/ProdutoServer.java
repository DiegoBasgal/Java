package server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.List;

import server.produto.Produto;
import server.produto.Produtos;

public class ProdutoServer {

    private int port;
    private String host;
    private MulticastSocket multicastSocket;
    private String loja;

    public ProdutoServer(int port, String host, String loja) {
        this.port = port;
        this.host = host;
        this.loja = loja;
        newInstanceMultCastSocket();
    }

    public void iniciar() {
        while (Boolean.TRUE) {
            DatagramPacket packetRec = receberPackect();
            String nomeProdutoPesquisa = extrairNomeProdutoPesquisa(packetRec);
            List<Produto> listProdutos = Produtos.instance().getProdutosContemName(nomeProdutoPesquisa, this.loja);
            retornarProdutos(listProdutos, packetRec);
        }
    }

    private void retornarProdutos(List<Produto> listProdutos, DatagramPacket packetRec) {
        byte[] bytes = serializar(listProdutos);
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, packetRec.getAddress(), packetRec.getPort());
        try {
            this.multicastSocket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] serializar(List<Produto> listProdutos) {
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteArray);
            out.writeObject(listProdutos);
            out.flush();
            return byteArray.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String extrairNomeProdutoPesquisa(DatagramPacket packetRec) {
        return new String(packetRec.getData()).trim();
    }

    private DatagramPacket receberPackect() {
        DatagramPacket packetRec = new DatagramPacket(new byte[512], 512);
        try {
            this.multicastSocket.receive(packetRec);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return packetRec;
    }

    private void newInstanceMultCastSocket() {
        try {
            this.multicastSocket = new MulticastSocket(this.port);
            this.multicastSocket.joinGroup(InetAddress.getByName(this.host));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
