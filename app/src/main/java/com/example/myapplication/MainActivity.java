package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isIsogram("abcserdh");


       // function call for sorting the odd item only
        int[] intArray = new int[]{ 5,3,2,8,1,4};
        int[] sortedArray=sortArrayAsc(intArray);
        for (int sortedValue : sortedArray) {
            Log.d("AscSort", String.valueOf(sortedValue));
        }



        List<String> smileys=new ArrayList<>();
//       smileys.add(":)"); smileys.add(":D"); smileys.add(":-}"); smileys.add(":-()");
//        smileys.add(":)"); smileys.add(":)"); smileys.add("x-]"); smileys.add(":ox"); smileys.add(";-("); smileys.add(";-)"); smileys.add(";~("); smileys.add(":~D");

        smileys.add(":)"); smileys.add("XD"); smileys.add(":0}"); smileys.add("x:-"); smileys.add("):-"); smileys.add("D:");


        int totalSmileysCount=countSmileys(smileys);
        Log.d("SmileyCount", String.valueOf(totalSmileysCount));

       /* int[] intArray1 = new int[]{9,9,7,0,6,5,5,7,5,7};

        Log.d("Mobile", String.valueOf(createPhoneNumber(intArray1)));*/

    }


    // isoGram is the  word in which no redunandunt char is present
    private   boolean  isIsogram(String str) {

        char[] myString = str.toCharArray();

        boolean isIsogram=true;
        char test;
        for (int i = 0; i < myString.length-1 ; i ++ )
        {
            test = Character.toLowerCase(myString[i]);
            for(int j= i; j < myString.length-1; j++) {
                if (test == Character.toLowerCase(myString[j + 1])) {
                    isIsogram = false;
                    return isIsogram;
                }
            }

        }

        return isIsogram;
    }

    // function to sort ascending only odd numbers in array?
    private int[] sortArrayAsc(int [] array)
    {

        for ( int i = array.length-1 ; i > 0 ; i -- )
        {

            //If the value is 'even' continue with outer loop
            if(array[i] % 2 == 0)
                continue;

            for (int j = i ; j > 0 ; j--)
            {

                if( array[i] < array[j-1])
                {
                    //If this value is not even do comparison
                    if(array[j-1]% 2 != 0) {
                        array[i] = array[i] + array[j - 1] - (array[j - 1] = array[i]);
                    }

                }

            }

        }

        return array;
    }


    private int countSmileys(List<String> smileys)
    {

        int totalSmileysCount=0;
        char[] specialChar;
        boolean isSmiley=false;

        for (String smiley : smileys) {
            isSmiley=false;
            specialChar = smiley.toCharArray();

            for(int i = 1 ; i < specialChar.length;i++)
            {

                if(i==1)
                {
                    if ((specialChar[i] == ')' || specialChar[i] == 'D') && (specialChar[i-1] == ':' || specialChar[i-1] == ';')) {
                        isSmiley=true;
                        break;
                    }
                   else if((specialChar[i]=='-' || specialChar[i]=='~') && (specialChar[i-1] == ':' || specialChar[i-1] == ';'))
                    {

                        if(specialChar[i+1]=='D' || specialChar[i+1]==')')
                        {
                            isSmiley=true;
                        }
                        else
                        isSmiley=false;
                    }
                    else
                        isSmiley=false;
                }

                if(i==3)
                {
                    isSmiley=false;
                }


            }

            if (isSmiley) {
                totalSmileysCount = totalSmileysCount + 1;

            }



        }



        return totalSmileysCount;
    }


    //my method
    private String getMobileNumbers(int[] mobileNumbers)
    {

        StringBuilder mobileNumber = new StringBuilder();
        List<String> digits= new ArrayList<>();

        for (int number : mobileNumbers) {
            digits.add(String.valueOf(number));
        }

        digits.add(0,"(");
        digits.add(4,")");
        digits.add(5," ");
        digits.add(9,"-");


        for (int i = 0; i < digits.size(); i++) {
            mobileNumber.append(digits.get(i));
        }

        return mobileNumber.toString();
    }


    //liked method picked from kata
    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");

        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }


}
