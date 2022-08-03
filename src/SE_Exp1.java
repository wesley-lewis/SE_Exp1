import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import netscape.javascript.JSObject;

import javax.lang.model.type.NullType;

public class SE_Exp1 {
    private HashMap<Integer, Integer> classAndCapacity = new HashMap<Integer, Integer>();
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private HashMap<String,String> map1 = new HashMap<>();
    private HashMap<String,String> map2 = new HashMap<>();

    public ArrayList<String> getCourses() {

        return courses;
    }

    public ArrayList<String> getTime() {

        return time;
    }
    public HashMap<Integer, Integer> getClassCapacity()
    {
        return classAndCapacity;
    }

    public void inputData1(String inputFile) {
        JSONParser parser = new JSONParser();
        try {
            // Object obj = parser.parse(new FileReader(inputFile));

            Object obj = parser.parse(new FileReader(inputFile));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray subjects = (JSONArray)jsonObject.get("courses");
            System.out.println(subjects.getClass().getSimpleName());

            for (Object subject : subjects) {
                courses.add((String) subject);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Input file doesn't exist");
        }
    }

    public void inputData2(String input)
    {

        BufferedReader reader = null;
        String line ="";

        try {
            reader = new BufferedReader(new FileReader(input));

            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                System.out.println(row[1]);
                map1.put(row[0],row[1]);
            }
            System.out.println(map1);


            //second part
            reader = new BufferedReader(new FileReader(input));

            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                map2.put(row[0],row[2]);



            }
            System.out.println(map2);
        }

        catch (Exception e){
            System.out.println(e);
            System.out.println("Input file doesn't exist");
        }
    }

    public void noCourse()
    {

        String maincourse ="", notavailable="",flag;
        int temp = 0;

        for(Map.Entry<String,String>set:map2.entrySet())
        {
            temp = 0;
            flag = set.getKey();

            for (String cours : courses) {
                if (flag.equals(cours)) {
                    temp = 1;
                    maincourse += cours + " ";
                }

            }
            if(temp == 0) {
                notavailable += set.getKey() + " " ;
            }
        }
        System.out.println(notavailable);
        System.out.println(maincourse);
    }

}

class TestSE {
    public static void main(String[] args) {
        SE_Exp1 obj = new SE_Exp1();
        obj.inputData1("C:\\Users\\vailantan fernandes\\IdeaProjects\\SE_EXP_\\src\\input.json");

        obj.inputData2(  "C:\\Users\\vailantan fernandes\\IdeaProjects\\SE_EXP_\\src\\inutfile2.csv");
        obj.noCourse();
    }
}