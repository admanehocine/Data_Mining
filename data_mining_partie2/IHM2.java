package data_mining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class IHM2 {
    public static ArrayList<Double>
            A = new ArrayList<>(),
            P = new ArrayList<>(),
            C = new ArrayList<>(),
            LoK = new ArrayList<>(),
            WoK = new ArrayList<>(),
            AC = new ArrayList<>(),
            LoKG = new ArrayList<>();
    public static ArrayList<String> Class = new ArrayList<>();
    public static ArrayList<Double> u1, u2, u3, u4, u5, u6, u7;
    /* You need this item lists, DONT CHANGE THEIR NAMES */
    public static ArrayList<String> item_A, item_P, item_C, item_LoK, item_WoK, item_AC, item_LoKG;
    /* Apriori Result */
    public static HashMap<ArrayList<String>, Integer> AprioriResult = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("seeds.txt"));
        String line;
        String[] temp;

        while ((line = br.readLine()) != null) {
            temp = line.split("\t+");
            A.add(Double.valueOf(temp[0]));
            P.add(Double.valueOf(temp[1]));
            C.add(Double.valueOf(temp[2]));
            LoK.add(Double.valueOf(temp[3]));
            WoK.add(Double.valueOf(temp[4]));
            AC.add(Double.valueOf(temp[5]));
            LoKG.add(Double.valueOf(temp[6]));
            switch (temp[7]) {
                case "1":
                    Class.add("Kama");
                    break;
                case "2":
                    Class.add("Rosa");
                    break;
                case "3":
                    Class.add("Canadian");
                    break;
            }
        }

        u1 = Normalize_Z_Score(A);
        u3 = Normalize_Z_Score(C);
        u2 = Normalize_Z_Score(P);
        u4 = Normalize_Z_Score(LoK);
        u5 = Normalize_Z_Score(WoK);
        u6 = Normalize_Z_Score(AC);
        u7 = Normalize_Z_Score(LoKG);

        item_A = DiscreteAmplitude(u1, 1, 4, 0.0001);
        item_P = DiscreteAmplitude(u2, 2, 4, 0.0001);
        item_C = DiscreteAmplitude(u3, 3, 4, 0.0001);
        item_LoK = DiscreteAmplitude(u4, 4, 4, 0.0001);
        item_WoK = DiscreteAmplitude(u5, 5, 4, 0.0001);
        item_AC = DiscreteAmplitude(u6, 6, 4, 0.0001);
        item_LoKG = DiscreteAmplitude(u7, 7, 4, 0.0001);

        HashSet<HashSet<String>> l = Apriori(0.2);
        System.out.println("Apriori final result:\n"+l);
        System.out.println();
        System.out.println("HashMap<ArrayList, int>:\n"+AprioriResult);

    }

    public static Double moy(ArrayList<Double> list) {
        double sum = 0;
        for (double x : list)
            sum += x;
        return sum / list.size();
    }

    /*+*************************************************************************************************************
     **** Part 2 ****************************************************************************************************
     ****************************************************************************************************************/


    /**
     * NewValue = (CurrentValue - MinValue) / (MaxValue - MinValue)) * (NewMax - NewMin) + NewMin
     * @param InputList must be a (double) list
     * @return a new normalized list
     */
    @SuppressWarnings("unused")
    public static ArrayList<Double>
    NormalizeMinMax(ArrayList<Double> InputList, double NewMin, double NewMax) {
        if(InputList.isEmpty())
                return new ArrayList<>();
        ArrayList<Double> OutputList = new ArrayList<>();
        double MaxValue = Collections.max(InputList);
        double MinValue = Collections.min(InputList);
        DecimalFormat f = new DecimalFormat("#0.00"); // 3 numbers after comma
        double temp;
        for (double i : InputList) {
            temp = ((i - MinValue) / (MaxValue - MinValue)) * (NewMax - NewMin) + NewMin;
            OutputList.add(Double.parseDouble(f.format(temp)));
        }

        return OutputList;
    }

    /**
     * NewValue = (CurrentValue - mean) / sum(CurrentValue_i - mean)
     */
    @SuppressWarnings("unused")
    public static ArrayList<Double>
    Normalize_Z_Score(ArrayList<Double> InputList) {
        if(InputList.isEmpty())
            return new ArrayList<>();
        ArrayList<Double> OutputList = new ArrayList<>();
        double moy = moy(InputList), sum = 0;
        int n = InputList.size();
        DecimalFormat f = new DecimalFormat("#0.00"); // 2 numbers after comma
        for (double i : InputList) {
            sum += Math.abs(i - moy);
        }
        sum = sum / n;
        for (double i : InputList) {
            OutputList.add(Double.parseDouble(f.format((i - moy) / sum)));
        }
        return OutputList;
    }

    /**
     * @param input      Given list
     * @param num_list   list number (must be correct)
     * @param Q          number of intervals
     * @return item list
     */
    @SuppressWarnings("unused")
    public static ArrayList<String>
    DiscreteEffective(ArrayList<Double> input, int num_list, int Q) {
        if(input.isEmpty())
            return new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();                   /* Item List output */
        ArrayList<Double> copyList = new ArrayList<>(input);            /* Copy of input list */
        Collections.sort(copyList);
        ArrayList<Double> quartiles = new ArrayList<>();                /* list of quartiles */

        int n = input.size();
        double min, max, temp;
        min = copyList.get(0);                                          /* Get minimum (Q0)*/
        quartiles.add(min);

        for (int i=1; i <= Q; i++){
            temp = (n/(double)Q)*i;                                     /* Get exact position of quartile*/
            if(temp%1>0.5)                                              /* If its bigger than xx.5, the its rounded to next int value*/
                temp = Math.ceil(temp);
            else
                temp = Math.floor(temp);                                /* Else its floored down */
            quartiles.add(copyList.get((int)temp-1));                   /* Now get that element which quartile points to*/
        }

        for (double i : input) {                                                /*For each element in input list*/
            for (int ind = 0; ind < quartiles.size() - 1; ind++) {
                if (i >= quartiles.get(ind) && i < quartiles.get(ind + 1)) {    /* If its between [Q(i), Q(i+1)[ */
                    output.add("I" + num_list + (ind + 1));                     /* Concat 'I' list number and its interval index */
                }
            }
            if(i == quartiles.get(quartiles.size()-1)){                         /* just to take max value into consideration */
                output.add("I" + num_list + (quartiles.size()-1));
            }
        }

        return output;
    }

    /**
     * @param input      Given list
     * @param num_list   list number (must be correct)
     * @param Q          number of intervals
     * @param correction small value to include max into intervals, (default 0.01)
     * @return item list
     */
    @SuppressWarnings("unused")
    public static ArrayList<String>
    DiscreteAmplitude(ArrayList<Double> input, int num_list, int Q, double correction) {
        if(input.isEmpty())
            return new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();                   /* Item list*/
        ArrayList<Double> intervals = new ArrayList<>();                /* list of intervals*/
        double min, max, amp, temp;
        min = Collections.min(input);                                   /* Get minimum */
        max = Collections.max(input);                                   /* Get maximum */
        amp = ((max - min) / Q) + correction;                           /* Calculate amplitude by its formula */

        temp = min;
        intervals.add(temp);
        while (temp < max) {                                            /* Create intervals */
            temp += amp;
            intervals.add(temp);
        }

        for (double i : input) {                                /*Determine where the list values located within intervals*/
            for (int ind = 0; ind < intervals.size() - 1; ind++) {
                if (i >= intervals.get(ind) && i < intervals.get(ind + 1)) {    /* If its between [Interval(i), Interval(i+1)[ */
                    output.add("I" + num_list + (ind + 1));                     /* Concat 'I' list number and its interval index */
                }
            }
        }
        return output;
    }

    /*+**************************************************************************************************************
     **** Apriori ****************************************************************************************************
     ****************************************************************************************************************/

    /**
     * @param MinSupport you know what's this, needs to be a percentage; 0~1
     * @return A set of sets L1 ~union~ L2 ~union~ L3
     */
    @SuppressWarnings("unused")
    public static HashSet<HashSet<String>>
    Apriori(double MinSupport){    /* MinSupport needs to be a percentage; 0~1*/
        HashSet<HashSet<String>>
                L = Create_1_ItemSet(MinSupport),           /* Lk in Apriori, we start with Creating L1 */
                L_PlusOne,                                  /* Lk+1  Creating next set */
                OutputSet= new HashSet<>(L);                /* Concat all sets L1 ~union~ L2 ~union~ L3 ... */
        int k = 2;                                          /* Index of L_PlusOne */

        do{
            L_PlusOne = CreateNextL(L, k, MinSupport);      /* Get Lk+1 */
            L = L_PlusOne;                                  /* Update L */
            OutputSet.addAll(L);                            /* append to output */
            k++;                                            /* get ready for next List L_PlusOne */
        } while (!L.isEmpty());                             /* Stop when List's empty */
        return OutputSet;
    }

    /**
     * The function everybody dreamed about
     * @param ItemSet a set of items, like [I11, I24, I36 ...]
     * @return It's support
     */
    @SuppressWarnings("unused")
    public static int
    CalcSupport(HashSet<String> ItemSet){
        if(ItemSet.isEmpty())
            return 0;
        int n = item_A.size();                      /* Dataset's Length */
        int CurrentSupport = 0;                     /* Calculate current support */
        boolean SameLine;                           /* Check if all items from itemSet are found  on the same line of dataset (instance) */

        Map<String, ArrayList<String>> Tab = new HashMap<>();   /*Map of items with their concerning list,  Item: <List>*/

        for(String item: ItemSet){       /* init map by adding all corresponding lists, ex: if we found I16, we add list _A_ to Tab */
            Tab.put(item, new ArrayList<>(GetListFromItem(item.charAt(1))));
        }

        for(int i=0; i<n; i++){                             /* For all instances */
            SameLine = true;                                /* Suppose we found a line containing all items */
            for(String key: Tab.keySet()){                  /* For each item from the map */
                if(!Tab.get(key).get(i).equals(key)){       /* if an item is not found in its list in this current instance */
                    SameLine = false;                       /* then dont bother checking the other one */
                    break;
                }
            }
            if(SameLine) {                                  /* if we found all item in current instance */
                CurrentSupport++;
            }
        }
        return CurrentSupport;
    }

    /*---------------------------------------------- [Helper Functions] ----------------------------------------------*/
    /*-------------------------------------------- [No need to call them] --------------------------------------------*/
    /**
     * @param L Precedent L set
     * @param k Current List number
     * @param MinSupport Guess what?
     * @return Lk+1, it also prints (Ck+1, Lk+1)
     */
    private static
    HashSet<HashSet<String>>
    CreateNextL(HashSet<HashSet<String>> L, int k, double MinSupport){
        HashSet<HashSet<String>>
                Output = new HashSet<>();               /* This is Lk+1 */
        HashSet<String>
                combinedSet,                            /* Combination set: for creating all possible combination */
                NextC = new HashSet<>(),                /* Next Candidate list (K+1), used for printing only */
                NextL = new HashSet<>();                /* Next "Valid" list (K+1), also used for printing only */

        MinSupport = MinSupport * item_A.size();        /* Recalculate support */
        int CurrentSupport;                             /* Current support of current combined set */

        for(HashSet<String > set1: L){                  /* For Set1 and Set2 in L, while Set1 != Set2 */
            for(HashSet<String > set2: L){              /*                  ||                        */
                if(set1.hashCode() != set2.hashCode()){   /*                  ||                        */
                    combinedSet = new HashSet<>();
                    combinedSet.addAll(set1);
                    combinedSet.addAll(set2);           /* Creating combined set, it doesn't add duplicates */
                    if (combinedSet.size() >= k){       /* We dont want to create small combinations, smaller than k anyway */
                        CurrentSupport = CalcSupport(combinedSet);                      /* Get support */
                        NextC.add(combinedSet.toString() + ": " + CurrentSupport);      /* Adding to candidate list*/
                        if(CurrentSupport >= MinSupport){                               /* If its greater, then it belongs to Lk+1 */
                            Output.add(combinedSet);                                    /* Adding to Lk+1*/
                            NextL.add(combinedSet.toString() + ": " + CurrentSupport);          /* Also adding to Lk+1 but this one's for printing only*/
                            AprioriResult.put(new ArrayList<>(combinedSet), CurrentSupport);    /* Hadi lik HOCINE */
                        }
                    }
                }
            }
        }

        /* Write this down in your JFrame will ya */
        System.out.println("C" + k + ":\n" + NextC + "");
        System.out.println("L" + k + ":\n" + NextL + "");
        System.out.println();
        return  Output;
    }

    /**
     * First step of Apriori algorithm
     * @param MinSupport Guess what's this
     * @return A set of sets (containing 1-ItemSets), ex [[I11], [I42], [I63], ...], it also prints (Ck+1, Lk+1)
     */
    private static HashSet<HashSet<String>>
    Create_1_ItemSet(double MinSupport) {
        MinSupport = (int) Math.floor(MinSupport * item_A.size());              /* Recalculate minimum support */

        Set<String> AllItems = new HashSet<>();                                 /* A Set of all items*/
        AllItems.addAll(item_A);                                                /* Add All */
        AllItems.addAll(item_P);
        AllItems.addAll(item_C);
        AllItems.addAll(item_LoK);
        AllItems.addAll(item_WoK);
        AllItems.addAll(item_AC);
        AllItems.addAll(item_LoKG);

        ArrayList<String> currentList;                                          /* Get attribute list of current item */
                                                                                /* Ex: if item = "I24" then current list is list _P_*/
        HashSet<HashSet<String>> output = new HashSet<>();                      /* This is actually L1 used in algorithm*/
        HashSet<String> L1 = new HashSet<>(), C1 = new HashSet<>();             /* C1 and L1 are used for printing*/
        int CurrentSupport;                                                     /* Current Support */

        for (String key : AllItems) {                                           /* For each item */
            currentList = GetListFromItem(key.charAt(1));                       /* get its list */
            CurrentSupport = Collections.frequency(currentList, key);           /* Calculate support, (Function frequency)*/
            C1.add(key+": "+CurrentSupport);                                    /* Add to C1*/
            if (CurrentSupport >= MinSupport) {                                 /* If it has min support */
                L1.add(key+": "+CurrentSupport);                                /* Add to L1 */
                output.add(new HashSet<>(Collections.singleton(key)));          /* Add to real L1, lol*/
                AprioriResult.put(new ArrayList<>(Collections.singleton(key)), CurrentSupport);    /* Hadi lik HOCINE */
            }
        }

        /* Write this down in your JFrame please */
        System.out.println("C1:\n" + C1 + "");
        System.out.println("L1:\n" + L1 + "");
        System.out.println();
        return output;
    }

    /**
     * Help's you which list the item belongs to
     * Like: 'I34' ~ 'I(3)4' -> 3rd list, so its attribute 'C'
     * @param ch the index (comes after 'I' in item)
     * @return its list
     */
    private static ArrayList<String>
    GetListFromItem(char ch) {
        switch (ch) {                           /* Go and get the list */
            case '1':
                return item_A;
            case '2':
                return item_P;
            case '3':
                return item_C;
            case '4':
                return item_LoK;
            case '5':
                return item_WoK;
            case '6':
                return item_AC;
            case '7':
                return item_LoKG;
            default:
                return  new ArrayList<>();          /* Return empty */
        }
    }

    /*+**************************************************************************************************************
     **** End Part 2 *************************************************************************************************
     ****************************************************************************************************************/

}