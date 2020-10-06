
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadingFromXml {

    public static void main(String[] args){
        try {
            File xmlDoc = new File("students.xml");
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dbFact.newDocumentBuilder();
            Document doc = dBuild.parse(xmlDoc);

            //Read root element
            //                                     doc locate root         give me its element name
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // read array of students
            //this called nodelist

            NodeList nList = doc.getElementsByTagName("student");
            float All_Students_Math_score = 0;
            float All_Students_English_score = 0;
            float All_Students_Physics_score = 0;
            float Students_num = nList.getLength();
            for(int i=0 ; i<nList.getLength();i++){

                Node nNode = nList.item(i);
                System.out.println("Node name:   " + nNode.getNodeName() + " " + (i+1));
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Student ID#: " + eElement.getAttribute(("idno")));
                    System.out.println("Student Name: " + eElement.getElementsByTagName(("student_name")).item(0).getTextContent());
                    System.out.println("Math score : " + eElement.getElementsByTagName(("math")).item(0).getTextContent());
                    All_Students_Math_score += Float.parseFloat(eElement.getElementsByTagName(("math")).item(0).getTextContent());
                    System.out.println("Eng score: " + eElement.getElementsByTagName(("english")).item(0).getTextContent());
                    All_Students_English_score += Float.parseFloat(eElement.getElementsByTagName(("english")).item(0).getTextContent());
                    System.out.println("Physics score: " + eElement.getElementsByTagName(("physics")).item(0).getTextContent());
                    All_Students_Physics_score += Float.parseFloat(eElement.getElementsByTagName(("physics")).item(0).getTextContent());
                }

            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Math score of all students - " + All_Students_Math_score/Students_num);
            System.out.println("English score of all students - " + All_Students_English_score/Students_num);
            System.out.println("Physics score of all students - " + All_Students_Physics_score/Students_num);
        }
        catch (Exception e){

        }

    }

}
