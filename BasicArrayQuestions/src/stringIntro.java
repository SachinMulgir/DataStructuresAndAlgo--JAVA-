import java.util.*;
public class stringIntro {
    public static void main(String[] args) {
        //Declaration
        String firstName="Sachin";
        String secondName="Mulgir";
//        System.out.println("normal output of the string: "+ firstName+secondName);

        //User Input
        Scanner sc=new Scanner(System.in);
//        System.out.println("input word:");
//        String singleInput=sc.next();                              //single word input
//        System.out.println("singleWord:"+singleInput);
//        System.out.println("input whole line:");
//        String lineInput=sc.nextLine();                           //complete line input
//        System.out.println("wholeLine:"+lineInput);

        //FUNCTIONS IN STRINGS

//          //1. CONCATENATION:
//              String name1="Tony";
//              String name2="Stark";
//              String concat=name1 + name2;
//              System.out.println("CONCATENATED string:"+name1+name2);
//              System.out.println();

        //--------------------------------------------------------------------------------------------------------------
//
//          //2. .length(): gives the length of the string
//                String lenName="Sachin Mulgir";
//                  System.out.println("length of the string is: "+lenName.length());
//                  System.out.println();

        //--------------------------------------------------------------------------------------------------------------
//
//           //3. .charAt(): used to fetch a particular character a particular place in a string
//                String charAtName="Sachin Mulgir";
//              for(int i=0;i<charAtName.length();i++){
//                    System.out.print(charAtName.charAt(i)+" ");
//                 }
//        System.out.println();

        //--------------------------------------------------------------------------------------------------------------


//          //4. .compareTo(): compare two strings and returns 1.positive(if s1<s2) 2.negative(if s1>s2) 3.zero(if s1==s2)
//            String name1="Sachin";
//            String name2="Aachin";
//           System.out.println(name1.compareTo(name2));
//          // strings are case sensitive, therefore if we have "sachin" and "Sachin", then it'll not consider them equal.
//          //for that we use =(.compareToIgnoreCase())
//            String s1="sachin";
//            String s2="Sachin";
//        System.out.println(s1.compareToIgnoreCase(s2));            //will consider them equal.

        //--------------------------------------------------------------------------------------------------------------

            //5. .substring(): a subset of string is taken. <arr>.substring(<start>,<end>);
//
//                String name="Sachin Mulgir";
//        System.out.println(name.substring(7));

        //--------------------------------------------------------------------------------------------------------------

            //6. .toLowerCase(): will turn all the character of a string to lower case characters
            //7. .toUpperCase(): will turn all the character of a string to upper case characters.
//                String name="SacHin";
//        System.out.println(name.toLowerCase());
//        System.out.println(name.toUpperCase());

        //--------------------------------------------------------------------------------------------------------------

//            //8. .trim(): will trim the string and remove all the free spaces before and after the string.(i.e at the ends)
//                    String line="       My         name is sachin     ";   //will only remove the spaces before 'My' and after 'sachin'
//                       System.out.println(line.trim());

        //--------------------------------------------------------------------------------------------------------------

//             //9. .replace('x','y') : will replace all the 'x' with 'y';
//                    String name="carrier";
//        System.out.println(name.replace('r','a'));      //can replace a char with char.
//        System.out.println(name.replace("rr","ABCDEFGHIJKLMNOPQURSTUVWXYA")); //can replace a char with a string.

        //--------------------------------------------------------------------------------------------------------------
//               //10. .startsWith(" ") : checks if the string starts with the given set of chars
//               //11. .endsWith(" "): checks if the string ends with the given set of chars.    (output: true/false);
//                    String name="kamehameha";
//        System.out.println(name.startsWith("kame"));
//        System.out.println(name.endsWith("eha"));
//        System.out.println(name.startsWith("Kame"));           //case sensitive....since it'll give false output

        //--------------------------------------------------------------------------------------------------------------

//                //12. indexOf('') : checks for the character or string and returns the index of the first match (else output=-1);
//                        String name="Shilpa Paswan";
//        System.out.println(name.indexOf('S'));                        //return index of first S char
//        System.out.println(name.indexOf("swan"));                     //return index of first "swan" string match     else(-1)

//               //13. .indexOf('s',3) : check for the character after index '3' element;
//                        String Name="Shilpa Paswan";
//        System.out.println(Name.indexOf('a',7));

        //--------------------------------------------------------------------------------------------------------------

//                 //14. .lastIndexOf(''): checks the character and returns the index of last element match found on the string
//                        String name="Shilpa Paswan";
//        System.out.println(name.lastIndexOf('a'));            //last match index is printed
//
//                //15. .lastIndexOf('',<index>): checks the character before teh mentioned index and returns the first match;
//        System.out.println(name.lastIndexOf('a',6));          //checks the string upto 6 index

        //--------------------------------------------------------------------------------------------------------------

                  //16. .equals(''); checks whether the string is equal to the given condition
                            String name="Sachin";
                            String name2="Sachin";
        System.out.println(name.equals(name2));      //both are equal, therefore output will be 'true';
        System.out.println(name.equals("Sachin"));   //we can compare stings by giving string inputs also; outpur: true;



    }
}
