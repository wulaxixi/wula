/*
 * $Id: $
 *
 * Copyright 2012 Stoyan Rachev (stoyanr@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FileUtils {
    private static final int BUF_SIZE = 256 * 1024;
    
    public interface TextProcessor{
        Boolean process(String text,String keyWord) throws InterruptedException;
    }

    public static boolean readFileToSearch(String keyWord,Path file) throws IOException {
        return readFileAsync(keyWord,file, (String text,String kw) -> {
        	if(text.contains(kw))
        		return true;
            return false;
        });
    }

    public static String readLinesToString(Path file) throws IOException {
        final StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()), BUF_SIZE)) {
            reader.lines().forEach(line -> {
                sb.append(line);
                sb.append('\n');
            });
        }
        return sb.toString();
    }

    public static Boolean readFileAsync(String keyWord,Path file, TextProcessor processor) throws IOException {
        try (AsynchronousFileChannel ac = AsynchronousFileChannel.open(file)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE);
            int pos = 0, read;
            String text = "";
            do {
                buffer.rewind();
                Future<Integer> future = ac.read(buffer, pos);
                if (!text.isEmpty()) {
                    if(processor.process(text,keyWord))return true;
                }
                while (!future.isDone()) {
                    Thread.yield();
                }
                buffer.flip();
                read = future.get();
                pos += read;
                text = Charset.defaultCharset().decode(buffer).toString();
            } while (read == buffer.capacity());
            if(processor.process(text,keyWord)) return true;
            return false;
        } catch (IOException e) {
            throw e;
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(String.format("Can't read file %s: %s", file.toString(), 
                e.getMessage()), e);
        }
    }
}
