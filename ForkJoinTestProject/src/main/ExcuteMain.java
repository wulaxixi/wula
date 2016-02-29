package main;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;

import Task.SearchWordTask;

public class ExcuteMain {
	
	private final static String KEYWORD = "8881784669010164866L";
	
	public static void main(String[] args) {
		int processors = Runtime.getRuntime().availableProcessors();
		int threshold = 2;//Math.max(1, (problems.size() / processors));
		long begin = System.currentTimeMillis();
		String rootPath = "C://TEMP//TESTDATA";
		ForkJoinPool pool = new ForkJoinPool(processors);
		SearchWordTask task = new SearchWordTask(rootPath, KEYWORD);
		Map<String, String> map = pool.invoke(task);
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-begin));
		for(String path:map.keySet()){
			System.out.println("包含关键字的文件有："+path);
		}
	}
	

}
