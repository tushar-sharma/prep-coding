import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.commons.lang.StringUtils;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.HashMap;

public class InvertedIndex {

    public static class MyArrayWritable extends ArrayWritable {

      public MyArrayWritable(String[] values) {
          super(values);
      }

      @Override
      public String toString() {
          return Arrays.toString(get());
      }

    }

    public static class MapClass
       extends Mapper<Object, Text, Text, Text>{

       private Text word = new Text();

        public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {

            FileSplit fileSplit = (FileSplit) context.getInputSplit();
            String filename = fileSplit.getPath().getName();


            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, new Text(filename));
            }
        }
      }


   public static class ReducerClass
       extends Reducer<Text, Text, Text, MyArrayWritable> {

    LinkedList<String> valueList = new LinkedList<String>();
    HashMap<String, Integer> records = new HashMap<String, Integer>();

    public void reduce(Text key, Iterable<Text> values,
                       Context context
                       ) throws IOException, InterruptedException {

       Iterator<Text> itr = values.iterator();

       while(itr.hasNext()) {
           Text st = itr.next();

           if (records.containsKey(st)) {
               continue;
           } else {
               records.put(st.toString(), 1);
           }
       }

       /*
        * String to arraywritable
        */

        context.write(key, new MyArrayWritable(records.keySet().toArray(new String[records.size()])));
    }
  }

    public static void main(String[] args) throws Exception {


        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "inverted index");


        job.setMapperClass(MapClass.class);
        job.setReducerClass(ReducerClass.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);


        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(MyArrayWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setJar("ii.jar");
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}
