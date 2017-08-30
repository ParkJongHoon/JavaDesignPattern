package tools.properties;

import java.io.File;
import java.util.Properties;
import java.util.StringTokenizer;

public class ClassNameStore extends Properties{
	private static ClassNameStore cns = new ClassNameStore();
	private ClassNameStore(){
		executePlan();
	}
	
	private String dirctoryPath= "class_name_store//";
	private String rootPath;
	private File directory;
	
	private void executePlan(){
		makeRootPath();
		dirctoryPath = rootPath + dirctoryPath;
		directory = new File(dirctoryPath);
		rootDrirectoryCreate();
	}
	
	private void rootDrirectoryCreate(){
		if(!directory.exists()){
			directory.mkdirs();
			System.out.println("Created directory successfully");
		}else{
			System.out.println("already exist");
		}
	}
	
	private void makeRootPath(){
		String thisClassPath = this.getClass().getResource(".").getPath();
		String rootPath = null;
		StringTokenizer st = new StringTokenizer(thisClassPath, "/");
		
		int count =0;
		
		while(st.hasMoreTokens()){
			if(count ==0){
				rootPath = st.nextToken() + "//";
				count++;
			}
			
			if(count >= 1){
				this.rootPath = rootPath;
				break;
			}
		}
	}

	public static ClassNameStore getCns() {
		return cns;
	}
	
	

}
