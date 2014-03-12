package org.test.pran.async;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by pramodh on 3/12/14.
 */
public class AsyncMainTest {
    public static void callBackAsync(){
        try {
            Path file = Paths.get("c:/onelargefile.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate(100_000);
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("Bytes Read " + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println(exc.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void futureAsync() {
        try {
            Path file = Paths.get("c:/onelargefile.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate(100_000);
            Future<Integer> result = channel.read(buffer, 0);
            while(!result.isDone()){
                System.out.println("Execute other logic");
            }
            Integer bytesRead = result.get();
            System.out.println("Bytes Read " + bytesRead);
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void networkChannelOption(){
        SelectorProvider provider = SelectorProvider.provider();
        try {
            NetworkChannel socketChannel = provider.openSocketChannel();
            SocketAddress address = new InetSocketAddress(3080);
            socketChannel.bind(address);
            Set<SocketOption<?>> socketOptions = socketChannel.supportedOptions();
            System.out.println(socketOptions.toString());
            socketChannel.setOption(StandardSocketOptions.IP_TOS, 3);
            Boolean keepAlive = socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);
            // rest of the code
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void multicastChannel(){
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName("net1");
            DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET);
            dc.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            dc.bind(new InetSocketAddress(8080));
            dc.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);
            InetAddress group = InetAddress.getByName("180.90.4.12");
            // join multicast group
            MembershipKey key = dc.join(group, networkInterface);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
