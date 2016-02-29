package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SingleThreadMain {

	private final static String KEYWORD = "8881784669010164866L";
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		String rootPath = "C://TEMP//TESTDATA";
		List<File> files = getAllSubFile(rootPath);
		HashMap<String, String> map = new HashMap<String,String>();
		for(File file:files){
			boolean result;
			try {
				result = utils.FileUtils.readFileToSearch(KEYWORD,
						Paths.get(file.getAbsolutePath()));
				if(result){
					map.put(file.getAbsolutePath(), KEYWORD);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-begin));
		for(String path:map.keySet()){
			System.out.println("包含关键字的文件有："+path);
		}

	}
	private static List<File> getAllSubFile(String rootPath){
		File srcDir = new File(rootPath);
		File[] files = srcDir.listFiles();
		List<File> fileList = new ArrayList<File>();
		for(File file:files){
			if(file.isDirectory())
				fileList.addAll(getAllSubFile(file.getAbsolutePath()));
			else fileList.add(file);
		}
		return fileList;
	}
	
}
