package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;

import example.classloader.SteganographyClassLoader;

public class Scene {

    public static void main(String[] args) throws Exception {

        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        SteganographyClassLoader loader = new SteganographyClassLoader(
                //new URL("file:example.QSorter.png"));
                //new URL("file:example.SSorter.png"));
                new URL("file:example.QuickSorter.png"));
                //new URL("file:example.SelectSorter.png"));
                //new URL("https://github.com/halipai/MYIMAGES/blob/main/java_W03/example.QSorter.png"));

        Class c;
        //c = loader.loadClass("example.BubbleSorter");
        //c = loader.loadClass("example.QSorter");
        //c = loader.loadClass("example.SSorter");
        c = loader.loadClass("example.QuickSorter");
        //c = loader.loadClass("example.SelectSorter");
        Sorter sorter = (Sorter) c.newInstance();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}