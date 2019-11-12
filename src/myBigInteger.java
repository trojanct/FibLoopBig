import java.io.*;
import java.lang.*;



public class myBigInteger {
    String value;


    public myBigInteger(String NewBigInt) {
        if (NewBigInt == null || NewBigInt.isEmpty()) {
            this.value = "0";
        } else {
            this.value = NewBigInt;
        }
    }

    public String ToString() {


        return value;

    }

    public String Multiply(myBigInteger y) {
        String equal = "";
        int i, j = 0;
        int size1;
        int size2;
        int temp1 = 0;
        int temp2 = 0;
        int max = 0;
        int min = 0;
        int tempEqual = 0;
        myBigInteger result;
        myBigInteger sum;
        char tempChar1;
        char tempChar2;
        int equalArray[];
        int carry = 0;


        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        a.append(this.value);
        b.append(y.value);

        a = a.reverse();
        b = b.reverse();

        size1 = this.value.length();
        size2 = y.value.length();

        if (size1 > size2) {
            max = size1;
            min = size2;
        } else {
            max = size2;
            min = size1;
        }
        equalArray = new int[max + min];
        sum = new myBigInteger(equal);
        for (i = 0; i < size1; i++) {


            for (j = 0; j < size2; j++) {
                //System.out.println(j);
                tempChar1 = a.charAt(i);
                tempChar2 = b.charAt(j);
                temp1 = tempChar1 - '0';
                temp2 = tempChar2 - '0';

                tempEqual = (temp1 * temp2) + carry;
                if (tempEqual >= 10) {
                    carry = tempEqual;
                    //System.out.println(tempEqual);
                    tempEqual = tempEqual % 10;
                    carry = (carry - tempEqual) / 10;
                    //System.out.println(carry);

                } else {
                    carry = 0;
                }
                equalArray[j + i] = tempEqual;


            }

            if (carry > 1) {

                equal += (char) (carry);
                carry = 0;
            }
            for (int k = size2 + i - 1; k >= 0; k--) {

                equal += (char) (equalArray[k] + '0');
            }
            result = new myBigInteger(equal);
            sum.value = sum.Plus(result);
            equal = "";
            equalArray[0 + i] = 0;

        }


        return sum.ToString();


    }

    public String Plus(myBigInteger y) {
        String equal = "";
        int i = 0;
        int size1;
        int size2;
        int temp1 = 0;
        int temp2 = 0;
        int max = 0;
        int min = 0;
        int tempEqual = 0;
        char tempChar1;
        char tempChar2;
        int equalArray[];
        int carry = 0;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        a.append(this.value);
        b.append(y.value);

        a = a.reverse();
        b = b.reverse();

        size1 = this.value.length();
        size2 = y.value.length();

        if (size1 > size2) {
            max = size1;
            min = size2;
        } else {
            max = size2;
            min = size1;
        }
        equalArray = new int[max];

        for (i = 0; i < max; i++) {


            if (i < min) {

                tempChar1 = a.charAt(i);
                tempChar2 = b.charAt(i);
                temp1 = tempChar1 - '0';
                temp2 = tempChar2 - '0';

                tempEqual = temp1 + temp2 + carry;
            } else if (i < size1) {
                tempChar1 = a.charAt(i);

                temp1 = tempChar1 - '0';

                tempEqual = temp1 + carry;
            } else //if( i < size2)
            {


                tempChar2 = b.charAt(i);

                temp2 = tempChar2 - '0';
                tempEqual = temp2 + carry;
            }

            if (tempEqual >= 10) {
                carry = 1;

                tempEqual = tempEqual - 10;
            } else {

                carry = 0;
            }

            equalArray[i] = tempEqual;


        }
        if (carry == 1) {

            equal += (char) (carry + '0');
        }
        for (i = max - 1; i >= 0; i--) {
            equal += (char) (equalArray[i] + '0');
        }


        //equal = y.value[i] + this.value[i];


        return equal;
    }
}
