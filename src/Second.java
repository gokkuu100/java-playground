public class Second {
    public static int nbYear(int p0, double percent, int aug, int p) {

        int years = 0;
        double currentPopulation = p0;

        while (currentPopulation < p) {
            currentPopulation += Math.floor((currentPopulation * (percent / 100)) + aug);
            years++;
        }
        return years;
    }

    public static void  evenLength(String myStr) {
        for (String w: myStr.split(" ")) {
            if (w.length() % 2 == 0) {
                System.out.println(w);
            }
        }
    }

    public static void insertString(String myStr) {
        StringBuffer s = new StringBuffer(myStr);
        String toInsert ="For";
        s.insert(4, toInsert);
        System.out.println(s.toString());
    }

    public static void reverseString(char[] myArray) {
        int left = 0;
        int right = myArray.length -1;
        while (left < right) {
            char temp = myArray[left];
            myArray[left] = myArray[right];
            myArray[right] = temp;

            left++;
            right--;
        }
    }


    public static String convertToInitials(String name) {
        String[] parts = name.split(" ");
        String initials = parts[0].substring(0,1).toUpperCase() + "." + parts[1].substring(0,1).toUpperCase();
        return initials;
    }

    public static String fakeBin(String numberString) {
        StringBuilder result = new StringBuilder();
        for (char digit: numberString.toCharArray()) {
            if (digit < '5') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        evenLength("Hope is cool");
        insertString("OmwamiGoku");
    }

}




