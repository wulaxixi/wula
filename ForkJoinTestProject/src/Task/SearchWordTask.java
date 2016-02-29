package Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * 处理任务类
 * @author yuanziyang
 *
 */
public class SearchWordTask extends RecursiveTask<Map<String,String>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8881784669010164866L;
	private String filePath;
	private String keyWord;
	
	public SearchWordTask(String filePath,String keyWord) {
		this.filePath = filePath;
		this.keyWord = keyWord;
	}
	
	@Override
	protected Map<String, String> compute() {
//		System.out.println("线程ID："+Thread.currentThread().getId()+"；线程名："+Thread.currentThread().getName());
		Path path = Paths.get(filePath);
		HashMap<String, String> map = new HashMap<String,String>();
		if(!Files.isDirectory(path)){
			try {
				boolean result = utils.FileUtils.readFileToSearch(keyWord, path);
				if(result){
					map.put(filePath, keyWord);
					return map;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			File parentFile = new File(filePath);
			File[] files = parentFile.listFiles();
			if(files.length>0){
				ArrayList<SearchWordTask> tasks = new ArrayList<SearchWordTask>();
				for(File file :files){
					SearchWordTask task = new SearchWordTask(file.getAbsolutePath(),keyWord);
					task.fork();
					tasks.add(task);
				}
				for(SearchWordTask task :tasks){
					try {
						map.putAll(task.get());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return map;
	}

}
