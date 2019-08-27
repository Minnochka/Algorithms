package Backpack;

import java.util.ArrayList;
import java.util.Iterator;

public class Backpack {

    private double weight;
    private double maxPrice;

    private ArrayList<Subject> subjectList = null;

    public Backpack(double weight){
        this.weight = weight;
    }

    private void findBestSet(ArrayList<Subject> subjects) {
        if(subjects.size() > 0){
            CheckSet(subjects);
        }

        for (int i = 0; i < subjects.size(); i++)
        {
            ArrayList<Subject> newSubjectSet = new ArrayList<Subject>(subjects);
            newSubjectSet.remove(i);
            findBestSet(newSubjectSet);
        }

    }

    private void CheckSet(ArrayList<Subject> subjects) {
        if (subjectList == null) {
            if (calculateWeigth(subjects) <= weight) {
                maxPrice = calculatePrice(subjects);
                subjectList = subjects;
            }
        } else {
            if (calculateWeigth(subjects) <= weight && calculatePrice(subjects) > maxPrice) {
                maxPrice = calculatePrice(subjects);
                subjectList = subjects;
            }
        }
    }


    private double calculateWeigth(ArrayList<Subject> subjects){
        double weightSum = 0;
        Iterator<Subject> subjectIterator = subjects.iterator();
        while (subjectIterator.hasNext()) {
            weightSum += subjectIterator.next().getWeigth();
        }

        return weightSum;
    }

    private double calculatePrice(ArrayList<Subject> subjects){
        double priceSum = 0;
        Iterator<Subject> subjectIterator = subjects.iterator();
        while (subjectIterator.hasNext()) {
            priceSum += subjectIterator.next().getPrice();
        }

        return priceSum;
    }

    public String getSubjectSet(ArrayList<Subject> subjects){
        String res = null;
        findBestSet(subjects);
        Iterator<Subject> subjectIterator = subjectList.iterator();
        while (subjectIterator.hasNext()) {
            if(res == null){
                res = subjectIterator.next().getName();
            }
            else{
                res += ", " + subjectIterator.next().getName();
            }
        }
        res = "Subjects list: " + res + '\n' + "Price: " + maxPrice;
        return res;
    }
}
