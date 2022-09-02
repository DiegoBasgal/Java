package rmi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import server.produto.Produto;

public class MultiCastClient {

	private int port;
	private String host;
	private MulticastSocket multicastSocket;
	private int time;
	
	public MultiCastClient(int port, String host, int time) {
		this.port = port;
		this.host = host;
		this.time = time;
		configMulticastSocket();
	}

	private void configMulticastSocket() {
		try {
			this.multicastSocket = new MulticastSocket();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			this.multicastSocket.setSoTimeout(this.time);
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> pesquisar(String nomeProduto) {
		List<Produto> listProdutos = new ArrayList<Produto>();
		DatagramPacket packet = dataGramPacketEnv(nomeProduto.getBytes());
		send(packet);
		DatagramPacket packetRec = receberPacket();
		if(packetRec != null)listProdutos.addAll(extrairProdutos(packetRec));
		packetRec = receberPacket();
		if(packetRec != null)listProdutos.addAll(extrairProdutos(packetRec));
		packetRec = receberPacket();
		if(packetRec != null)listProdutos.addAll(extrairProdutos(packetRec));
		return listProdutos;
	}

	@SuppressWarnings("unchecked")
	private List<Produto> extrairProdutos(DatagramPacket packetRec) {
		try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(packetRec.getData()))) {
			return (List<Produto>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private DatagramPacket receberPacket() {
		DatagramPacket packet = new DatagramPacket(new byte[4096], 4096);
		try {
			this.multicastSocket.receive(packet);
		} catch (IOException e) {
			if(e instanceof SocketTimeoutException) {
				return null;
			}
			throw new RuntimeException(e);
		}
		return packet;
	}

	private void send(DatagramPacket packet) {
		try {
			this.multicastSocket.send(packet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private DatagramPacket dataGramPacketEnv(byte[] bytes) {
		try {
			return new DatagramPacket(bytes, 
					  bytes.length,
					  InetAddress.getByName(this.host),
					  this.port);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
	
}
