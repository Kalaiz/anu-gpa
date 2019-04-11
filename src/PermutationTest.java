import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationTest {

    Permutation p=new Permutation(0,0);


    /**
     * A Brute force way of finding possible permutation given the totalpoints required- derived from factors like Estd GPA.
     * @param: totalPointsReqd - the total number of points required to achieve the estd GPA
     * @param: numOfCourses - the number of courses yet to be taken
     * @Return: An arraylist which contains all the "Required" permutation;permutation in accordance to estd GPA.
     */
    public List testPermutation(int totalPointsReqd, int numOfCourses){
        ArrayList permutations=new ArrayList();
        for(int hd=0;hd<numOfCourses;hd++){
            for(int d=0;d<numOfCourses-hd;d++){
                for(int cr=0;cr<numOfCourses-d;cr++){
                    for(int p=0;p<totalPointsReqd-cr;p++){
                        for(int f=0;f<totalPointsReqd-p;f++)
                        if(totalPointsReqd-(hd*7+d*6+cr*5+p*4)==0 && numOfCourses==hd+d+cr+p+f)
                            permutations.add(new int[]{hd,d,cr,p,f});
                    }
                }
            }
        }
        System.out.println(permutations.size());
        return permutations;}


    @Test
    public void baseCase() {
        p.pointsNeeded=0;
        p.numOfCourses=0;
        p.calculatePermutation();
        Object[] original=p.getPermutation().toArray();

        Object[] test=testPermutation(0,0).toArray();
        assertTrue("Wrong result for totalpointReqd: "+p.pointsNeeded+" & numOfCourses: " + p.numOfCourses,Arrays.deepEquals(original,test));
    }

    @Test
    public void test2() {
        p.pointsNeeded=102;
        p.numOfCourses=16;
        p.calculatePermutation();
        Object[] original=p.getPermutation().toArray();
        Object[] test=testPermutation(p.pointsNeeded,p.numOfCourses).toArray();
        assertTrue("Wrong result for totalpointReqd: "+p.pointsNeeded+" & numOfCourses: " + p.numOfCourses,Arrays.deepEquals(original,test));
    }

    @Test
    public void test3() {
        p.pointsNeeded=129;
        p.numOfCourses=20;
        p.calculatePermutation();
        Object[] original=p.getPermutation().toArray();
        Object[] test=testPermutation(p.pointsNeeded,p.numOfCourses).toArray();
        assertTrue("Wrong result for totalpointReqd: "+p.pointsNeeded+" & numOfCourses: " + p.numOfCourses,Arrays.deepEquals(original,test));
    }




}