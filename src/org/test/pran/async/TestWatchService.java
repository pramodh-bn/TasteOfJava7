package org.test.pran.async;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by pramodh on 3/11/14.
 */
public class TestWatchService {

    // explore symbolic links
    public static void exploreSymbolicLink(){
        Path file = Paths.get("c:/");
        try {
            if(Files.isSymbolicLink(file)){
                file = Files.readSymbolicLink(file);
            }
            Files.readAttributes(file, BasicFileAttributes.class);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    // Read file
    public static void readFile(){
        Path file = Paths.get("c:/eula.1028.txt");
        try(BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while((line = reader.readLine()) != null)
                System.out.println(line);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Write file
    public static void writeFile(){
        Path file = Paths.get("c:/temp.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
            writer.write("Hello World");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void simpleReadV7(){
        Path file = Paths.get("c:/eula.1028.txt");
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            byte[] bytes = Files.readAllBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLast1000Bytes(){
        Path file = Paths.get("c:/temp.log");
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            FileChannel channel = FileChannel.open(file, StandardOpenOption.READ);
            channel.read(buffer, channel.size()-1000); // read the last 1000 bytes
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // async class
    public static void main(String[] args) {
        try{
            boolean shutdown = false;
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = FileSystems.getDefault().getPath("c:/study/");
            WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
            while(!shutdown){
                key = watcher.take();
                for(WatchEvent<?> event: key.pollEvents()){
                    if(event.kind() == StandardWatchEventKinds.ENTRY_MODIFY)
                        System.out.println("Home directory changed");
                }
                key.reset();
            }
        } catch(InterruptedException | IOException ex){
            ex.printStackTrace();
        }
    }
}
