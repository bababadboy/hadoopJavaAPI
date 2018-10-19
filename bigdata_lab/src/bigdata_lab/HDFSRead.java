package bigdata_lab;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataInputStream;

public class HDFSRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		conf.set("dfs.defaultDFS", "dfs://localhost:9000");
		try{
			FileSystem fs = FileSystem.get(conf);
			String fn = "WriterFromJavaAPI";
			FSDataInputStream inStream = fs.open(new Path("WriterFromJavaAPI"));
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inStream));
			String line = bufferReader.readLine();
			System.out.println(line);
			bufferReader.close();
			fs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
