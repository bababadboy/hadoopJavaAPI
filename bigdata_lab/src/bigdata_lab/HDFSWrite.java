package bigdata_lab;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;
public class HDFSWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		conf.set("dfs.defaultFS", "dfs://localhost:9000");
//		conf.set("dfs.defaultPath", "");
		try{
			FileSystem fs = FileSystem.get(conf);
			byte[] buffer = "This is Richie.".getBytes();
			String filename = "WriterFromJavaAPI";
			FSDataOutputStream os = fs.create(new Path(filename));
			os.write(buffer);
			os.flush();
			System.out.println("Create file"+ filename);
			os.close();
			fs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
