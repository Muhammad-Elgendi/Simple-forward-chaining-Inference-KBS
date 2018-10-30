import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Simple forward-chaining algorithm for propositional logic  By: Muhammad Elgendi");
        
        // P => Q
        // L^M => P
        // B^L => M
        // A^P => L
        // A^B => L
        // A
        // B

        ArrayList<List<String>> clauses = new ArrayList<>();
        clauses.add(Arrays.asList("P", "Q"));
        clauses.add(Arrays.asList("LM", "P"));
        clauses.add(Arrays.asList("BL", "M"));
        clauses.add(Arrays.asList("AP", "L"));
        clauses.add(Arrays.asList("AB", "L"));
        clauses.add(Arrays.asList("", "A"));
        clauses.add(Arrays.asList("", "B"));

        // A  B  L  M  P  Q

        String inferred = new String();

        // We can add clause A, clause B manually to KB or just let the algorithm discover it's already there

        int counter = 0;
        int flagCount = 0;
        while (!clauses.isEmpty()) {
            // let the algorithm discover the clauses that's already asserted in KB
            if (clauses.get(counter).get(0).isEmpty()) {
                if(inferred.indexOf(clauses.get(counter).get(1)) == -1)
                    inferred += clauses.get(counter).get(1);
                System.out.println("From clause : "+clauses.get(counter).get(0)+" Inferred : "+clauses.get(counter).get(1)+" KB : "+inferred);
                clauses.remove(counter);
            } else {
                for (int i = 0; i < clauses.get(counter).get(0).length(); i++) {
                    if (inferred.indexOf(clauses.get(counter).get(0).charAt(i)) != -1) {
                        flagCount++;
                    }
                }
                if (flagCount == clauses.get(counter).get(0).length()) {
                    if(inferred.indexOf(clauses.get(counter).get(1)) == -1)
                        inferred += clauses.get(counter).get(1);
                    System.out.println("From clause : "+clauses.get(counter).get(0)+" Inferred : "+clauses.get(counter).get(1)+" KB : "+inferred);
                    clauses.remove(counter);
                }
            }
            counter++;
            if (clauses.size() == 0)
                break;
            counter %= clauses.size();
            flagCount = 0;
        }
    }
}
