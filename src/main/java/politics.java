import java.util.*;
/*Veronica Martucci
*COP3503 Spring 2022
* P1: Politics
*/
public class politics {

    public static void main(String[] args) {

        //read input
        Scanner input = new Scanner(System.in);
        int numCandidates = input.nextInt();
        int numSupporters = input.nextInt();

        while(numCandidates != 0){

            //array stores the list of candidates
            String candidates;

            //hashMap stores the candidate as the key and points to a list of supporters
            LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

            //scan in list of candidates into hashMap
            for(int i = 0; i <= numCandidates; i++){

                candidates = input.nextLine();
                map.put(candidates, new ArrayList<>());
            }

            //add supporter and supporting candidate to the hashMap
            for(int i = 0; i < numSupporters; i++){

                //read input
                String[] arr;
                arr = input.nextLine().split(" ");
                String supporter = arr[0];
                String suppCan = arr[1];

                //add supporter to candidate list in the hashMap
                if(map.containsKey(suppCan)){
                    ArrayList<String> list = map.get(suppCan);
                    list.add(supporter);
                    map.put(suppCan, list);

                }
                //if theres a "write in" candidate, then create a new key for the candidate
                else{
                    map.put(suppCan, new ArrayList<>());
                    ArrayList<String> list = map.get(suppCan);
                    list.add(supporter);
                    map.put(suppCan, list);
                }
            }

            //print hashmap map
            map.values().stream().flatMap(List :: stream).forEach(System.out::println);
            
            //have user input for next test case
            numCandidates = input.nextInt();
            numSupporters = input.nextInt();
        }
    }
}