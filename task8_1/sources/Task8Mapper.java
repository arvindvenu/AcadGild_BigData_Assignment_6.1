package mapreduce.task8_1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author arvind
 * This class provides the mapper implementation for Assignment 6.1 task 8_1
 */
public class Task8Mapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public static final String NA_STRING = "NA";
	
	
	
	/**
	 * This method takes as input key and value. The input key and value are 
	 * determined by the InputFormat class defined in the job driver. Since in this 
	 * case it is a TextInputFormat, the input key type will be LongWritable(offset of 
	 * the line from the beginning of the file) and iput value type will be of Text(the 
	 * actual contents of the line). Various fields in a particular line are separated by 
	 * pipe(|). In every line first field is company name. So splitting by pipe and checking 
	 * if the first and second field are not equal to NA. Only if they are not NA. 
	 * they will be output by the mapper,thereby filtering the records in the input file. 
	 * We have to calculate the number of units sold by each company. So companyName 
	 * has to be the key output by the mapper.And each line in the input represents 
	 * one unit sold. Therefore the value will be 1
	 */
	public void map(LongWritable lineOffsetInFile, Text recordInput, Context context) 
			throws IOException, InterruptedException {
		
		String[] recordFields = recordInput.toString().split("\\|");
		String companyName = recordFields[0].trim();
		String productName = recordFields[1].trim();
		if(!NA_STRING.equalsIgnoreCase(companyName) && 
				!NA_STRING.equalsIgnoreCase(productName) ) {
			context.write(new Text(companyName), new IntWritable(1));
		}
	} 
}
