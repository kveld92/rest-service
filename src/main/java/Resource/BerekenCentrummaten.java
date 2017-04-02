package Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Kevin Veld on 31-3-2017.
 */
public class BerekenCentrummaten {
    private List<Double> nummers = new ArrayList<Double>();

    public BerekenCentrummaten(List<Double> nummers){
        this.nummers = nummers;
    }

    private double berekenGemiddelde(){
        double total = 0;
        for (double i : nummers) {
            total += i;
        }
        total = total/(nummers.size());
        return total;
    }

    private double berekenMediaan(){
        List<Double> temp = nummers;
        Collections.sort(temp);
        int middle = temp.size()/2;

        if (temp.size()%2 == 1) {
            return temp.get(middle);
        } else {
            return (((temp.get(middle-1)) + (temp.get(middle))) / 2);
        }

    }

    private List<Double> berekenModaal(){
        List<Double> temp = nummers;
        TreeSet<Double> tree = new TreeSet<Double>();
        tree.addAll(nummers);

        //contains all the modes
        List<Double> modes = new ArrayList<Double>();

        double maxValue = 0;
        for (Double x : tree) {
            int freq = Collections.frequency(temp, x);
            if(freq == maxValue){
                modes.add(x);
            }
            if (freq > maxValue) {
                modes.clear();
                modes.add(x);
                maxValue = freq;
            }
        }

        return modes;
    }

    public String geefGemiddelde(){
        return Double.toString(berekenGemiddelde());
    }

    public String geefMediaan(){
        return Double.toString(berekenMediaan());
    }

    public List<Double> geefModaal(){
        return berekenModaal();
    }
}
